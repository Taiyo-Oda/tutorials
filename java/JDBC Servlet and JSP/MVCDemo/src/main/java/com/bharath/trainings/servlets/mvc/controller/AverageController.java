package com.bharath.trainings.servlets.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bharath.trainings.servlets.mvc.model.AverageCaluculator;

/**
 * Servlet implementation class AverageController
 */
@WebServlet("/AverageController")
public class AverageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num1 = Integer.parseInt(request.getParameter("number1"));
		int num2 = Integer.parseInt(request.getParameter("number2"));
		
		// モデルを使用するためのインスタンスを作成
		AverageCaluculator model = new AverageCaluculator();
		int result = model.calculate(num1, num2);
		// リクエストの属性を保存する
		request.setAttribute("result", result);
		
		// 与えられたパスにあるリソースのラッパーとして機能するRequestDispatcherオブジェクトを返す
		RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
		// サーブレットからのリクエストをサーバー上の別のリソース(サーブレット、JSPファイル、HTMLファイル)に転送する。
		// getRequestDispatcher() で取得した RequestDispatcher では、ServletRequest オブジェクトの path 要素とパラメータはターゲットリソースのパスに合うように調整される。
		dispatcher.forward(request, response);
	}

}
