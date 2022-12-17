package com.bharath.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateUserServlet
 */
// ここではアノテーションを利用してサーブレットをURIにマッピングしている
@WebServlet("/deleteServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
       
	// DBとの接続を行う
	public void init() {
		try {
			// Tomcatは自動的にJDBCドライバを検索してロードするサービスプロバイダメカニズムを無効にしているため、ドライバクラスを手動でロードしている
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "taiyou03");
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
		String email = request.getParameter("email");
		
		try {
			Statement statement = connection.createStatement();
			// INSERT、UPDATE、DELETE文、またはSQL DDL文のような何も返さないSQL文のいずれかを指定したSQL文を実行する
			int result = statement.executeUpdate("delete from user where email='" + email + "'");
			// クライアントに文字テキストを送信することができる PrintWriter オブジェクトを返す
			PrintWriter out = response.getWriter();
			if(result > 0) {
				out.print("<h1>User Deleted</h1>");
			} else {
				out.print("<h1>User not found in the datebase</h1>");
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
