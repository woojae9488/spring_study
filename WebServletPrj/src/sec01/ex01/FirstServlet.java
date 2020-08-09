package sec01.ex01;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("Call init method");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("Call doGet method");
	}

	@Override
	public void destroy() {
		System.out.println("Call destroy method");
	}
}
