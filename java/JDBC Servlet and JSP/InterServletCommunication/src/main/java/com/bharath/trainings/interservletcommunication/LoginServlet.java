package com.bharath.trainings.interservletcommunication;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "taiyou03");
			// データベースにSQL文を送信するためのStatementオブジェクトを作成
			Statement statement = con.createStatement();
			// 与えられたSQL文を実行し、1つのResultSetオブジェクトを返す
			ResultSet resultSet = statement.executeQuery("select * from user where email='" + userName + "' and password='" + password + "'");
			// 与えられたパスにあるリソースのラッパーとして動作する RequestDispatcher オブジェクトを返す。
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("homeServlet");
			if(resultSet.next()) {
				// このリクエストの属性を保存する。属性はリクエスト間でリセットされる。このメソッドは RequestDispatcher と一緒に使われることがほとんど
				request.setAttribute("message", "Welcome to InterServlet Communication " + userName);
				// サーブレットからのリクエストをサーバー上の別のリソース(サーブレット、JSPファイル、HTMLファイル)に転送します。
				//このメソッドにより、あるサーブレットがリクエストの前処理を行い、 別のリソースがレスポンスを生成することができます。
				requestDispatcher.forward(request, response);
			} else {
				requestDispatcher = request.getRequestDispatcher("login.html");
				// リソース (サーブレット、JSP ページ、HTML ファイル) のコンテンツをレスポンスにインクルードします
				requestDispatcher.include(request, response);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
