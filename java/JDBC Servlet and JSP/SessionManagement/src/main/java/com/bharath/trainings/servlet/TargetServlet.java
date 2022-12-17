package com.bharath.trainings.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TargetServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cookie[] cookies = req.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			System.out.println(cookies[i].getName());
			System.out.println(cookies[i].getValue());
		}

		HttpSession session = req.getSession();
		// このセッションで指定された名前でバインドされているオブジェクトを返します。
		String userName = (String)session.getAttribute("user");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.print("<h1>User Name Is : " + userName + "</h1>");
	}
	
}
