package com.bharath.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateUserServlet
 */
public class ReadUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
       
	// web.xmlの内容を読み込んで、configオブジェクトに格納している
	public void init(ServletConfig config) {
		try {
			// サーブレットコンテキストを取得
			ServletContext context = config.getServletContext();
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		try {
			Statement statement = connection.createStatement();
			// executeQuery：与えられたSQL文を実行し、1つのResultSetオブジェクトを返す
			ResultSet resultSet = statement.executeQuery("select * from user");
			// getWriter：クライアントに文字テキストを送信することができる PrintWriter オブジェクトを返す
			PrintWriter out = response.getWriter();
			out.print("<table>");
			out.print("<tr>");
			out.print("<th>");
			out.print("FirstName");
			out.print("</th>");
			out.print("<th>");
			out.print("LastName");
			out.print("</th>");
			out.print("<th>");
			out.print("Email");
			out.print("</th>");
			out.print("</tr>");
			while(resultSet.next()) {
				out.print("<tr>");
				
				out.print("<td>");
				out.print(resultSet.getString(1));
				out.print("</td>");
				out.print("<td>");
				out.print(resultSet.getString(2));
				out.print("</td>");
				out.print("<td>");
				out.print(resultSet.getString(3));
				out.print("</td>");
				
				out.print("</tr>");
			}
			out.print("</table>");
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
