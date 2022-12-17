package com.bharath.trainings.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SourceServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// クライアントがこのリクエストで送信したすべてのCookieオブジェクトを含む配列を返します。
		Cookie[] cookies = req.getCookies();
		// ブラウザでCookieが無効になっている場合は表示されない
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				System.out.println(cookies[i].getName());
				System.out.println(cookies[i].getValue());
			}
		}
		// 指定されたクッキーをレスポンスに追加します。(セッションIDをカスタマイズしたいときに使用する）
		resp.addCookie(new Cookie("securityToken", "12345"));
		
		String userName = req.getParameter("userName");
		// このリクエストに関連付けられた現在のセッションを返します。 リクエストがセッションを持っていない場合は、セッションを作成します。
		HttpSession session = req.getSession();
		// 指定された名前を使用して、このセッションにオブジェクトをバインドします。同じ名前のオブジェクトがすでにセッションにバインドされている場合、そのオブジェクトは置き換えられます。
		session.setAttribute("user", userName);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		// URLリライト（Cookieが無効になっている場合に備えて、URLのセッションIDの末尾を書き換える）
		String url = "targetServlet?sessionId=123";
		
		out.print("<a href='" + url + "'>Click Here To Get The User Name</a>");
	}

}
