package sec01.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("Call init method >>>> ");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Call doGet method >>>> ");
	}

	@Override
	public void destroy() {
		System.out.println("Call destroy method >>>> ");
	}
}
