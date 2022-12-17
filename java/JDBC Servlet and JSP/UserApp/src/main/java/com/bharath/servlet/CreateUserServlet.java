package com.bharath.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateUserServlet
 */
// ここではアノテーションを利用してinitパラメータを設定している
@WebServlet(urlPatterns = "/addServlet")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
       
	// web.xmlの内容を読み込んで、configオブジェクトに格納している
	public void init(ServletConfig config) {
		try {
			// サーブレットコンテキストを取得
			ServletContext context = config.getServletContext();
			// 全てのコンテキストパラメータを取得する
			Enumeration<String> parameterNames = context.getInitParameterNames();
			// コンテキストパラメータのNameとValueをコンソールに出力する
			while(parameterNames.hasMoreElements()) {
				String eachName = parameterNames.nextElement();
				System.out.println("Context Param Name : " + eachName);
				System.out.println("Context Param Value : " + context.getInitParameter(eachName));
			}
			
			// Tomcatは自動的にJDBCドライバを検索してロードするサービスプロバイダメカニズムを無効にしているため、ドライバクラスを手動でロードしている
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					context.getInitParameter("dbUrl"),
					context.getInitParameter("dbUser"),
					context.getInitParameter("dbPassword"));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			Statement statement = connection.createStatement();
			// INSERT、UPDATE、DELETE文、またはSQL DDL文のような何も返さないSQL文のいずれかを指定したSQL文を実行する
			int result = statement.executeUpdate(
					"insert into user values('" + firstName + "','" + lastName + "','" + email + "','" + password + "')"
					);
			// クライアントに文字テキストを送信することができる PrintWriter オブジェクトを返す
			PrintWriter out = response.getWriter();
			if(result > 0) {
				out.print("<h1>USER CREATED</h1>");
			} else {
				out.print("<h1>Error Creating the User</h1>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// DBとの接続を終了する
	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
