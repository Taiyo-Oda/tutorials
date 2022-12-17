package com.bharath.trainings.interservletcommunication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// LoginServletからのリクエストを受け取り、クライアントへのレスポンスを生成するServlet
/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/homeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		// 指定された属性の値を Object として返す。指定された名前の属性が存在しない場合は null を返す。
		out.print(request.getAttribute("message"));
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		// 指定された属性の値を Object として返す。指定された名前の属性が存在しない場合は null を返す。
		out.print(request.getAttribute("message"));
	}

}
