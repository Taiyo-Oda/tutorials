package com.bharath.trainings.jsp.customtags;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

// TagSupport : Tagを実装した新しいタグハンドラを定義するための基底クラス
public class ResultHandler extends TagSupport {

	Connection con;
	PreparedStatement stmt;

	public ResultHandler() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "taiyou03");
			stmt = con.prepareStatement("select * from user where email=?");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int doStartTag() throws JspException {
		// 入力されたEmailの値をリクエストオブジェクトから取得している
		ServletRequest request = pageContext.getRequest();
		String email = request.getParameter("email");

		try {
			// 検索するEmailの値をSQL文にセット
			stmt.setString(1, email);
			// SQL クエリを実行し、クエリによって生成された ResultSet オブジェクト作成
			ResultSet rs = stmt.executeQuery();
			JspWriter out = pageContext.getOut();
			if (rs.next()) {
				out.print("User Details are :<br/>First Name : ");
				out.print(rs.getString(1));
				out.print("<br/>Last Name : ");
				out.print(rs.getString(2));
			} else {
				out.print("Invalid Email Enterd");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// コンテナに次に何をすべきかを伝える整数値を返す
		// 今回のタグではボディを持たないので、アンダースコア・ボディをスキップすることにしている
		return Tag.SKIP_BODY;

	}

	@Override
	public void release() {
		try {
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
