package com.bharath.trainings.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloWorldServret extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		// クライアントに返すコンテンツタイプを指定する
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h1>Hello Servlets World</h1>");
		out.print("</body>");
		out.print("</html>");
	}

}
