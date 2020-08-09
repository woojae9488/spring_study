package sec08.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sec")
public class SecondServlet extends HttpServlet {
	public void init() {
		System.out.println("Call init method");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_address = request.getParameter("user_address");

		out.println("<html><body>");
		if (user_id != null && user_id.length() != 0) {
			out.println("You have been login!<br><br>");
			out.println("Id received from firstServlet: " + user_id + "<br>");
			out.println("Password received from firstServlet: " + user_pw + "<br>");
			out.println("Address received from firstServlet : " + user_address + "<br>");
			out.println("</body></html>");
		} else {
			out.println("You didn't login.<br><br>");
			out.println("Try login again!!<br>");
			out.println("<a href='/WebServletPrj/login3.html'>Move to Login page</>");
		}
	}

	public void destroy() {
		System.out.println("Call destroy method");
	}
}
