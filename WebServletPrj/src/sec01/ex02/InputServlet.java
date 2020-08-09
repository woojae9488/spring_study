package sec01.ex02;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/input")
public class InputServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("Call init method");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String user_id = req.getParameter("user_id");
		String user_pw = req.getParameter("user_pw");
		System.out.println("ID: " + user_id);
		System.out.println("PW: " + user_pw);
		String[] subject = req.getParameterValues("subject");
		for (String str : subject) {
			System.out.println("Selected subject: " + str);
		}

		System.out.println();
		Enumeration<String> enu = req.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = enu.nextElement();
			String[] values = req.getParameterValues(name);
			for (String value : values) {
				System.out.println("name=" + name + ", value=" + value);
			}
		}
	}

	@Override
	public void destroy() {
		System.out.println("Call destroy method");
	}
}
