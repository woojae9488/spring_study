package sec09.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sess3")
public class SessionTest3 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		out.println("Session Id : " + session.getId() + "<br>");
		out.println("Session created time : " + new Date(session.getCreationTime()) + "<br>");
		out.println("Session recent lookup time : " + new Date(session.getLastAccessedTime()) + "<br>");
		out.println("Session active time : " + session.getMaxInactiveInterval() + "<br>");
		if (session.isNew()) {
			out.print("Create new Session.");
		}
		session.invalidate();
	}
}
