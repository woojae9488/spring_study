package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("Call init method");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();

		String user_id = req.getParameter("user_id");
		String user_pw = req.getParameter("user_pw");

		StringBuilder data = new StringBuilder("<html>");
		data.append("<body>");
		data.append("ID : " + user_id);
		data.append("<br>");
		data.append("PW : " + user_pw);
		data.append("</body>");
		data.append("</html>");
		out.print(data);
	}

	@Override
	public void destroy() {
		System.out.println("Call destroy method");
	}
}
