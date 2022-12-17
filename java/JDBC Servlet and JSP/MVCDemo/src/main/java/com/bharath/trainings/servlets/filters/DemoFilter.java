package com.bharath.trainings.servlets.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class DemoFilter
 */
// サーブレットフィルタを適用するために宣言するアノテーション
// 指定されたURLパターンに対応するフィルターが適用される
@WebFilter("/FilterDemoServlet")
public class DemoFilter extends HttpFilter implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		PrintWriter out = response.getWriter();
		// リクエストが実行される前に実行したいロジックはここに記述する(暗号化など)
		out.print("Pre Servlet ");
		chain.doFilter(request, response);
		// レスポンスがクライアントに返される前に実行したいロジックはここに記述する
		out.print(" Post Servlet");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
