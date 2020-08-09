package sec10.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/getattr")
public class GetAttribute extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext ctx = getServletContext();
		HttpSession session = request.getSession();

		String ctxMesg = (String) ctx.getAttribute("context");
		String sesMesg = (String) session.getAttribute("session");
		String reqMesg = (String) request.getAttribute("request");

		out.println("Value of context : " + ctxMesg + "<br>");
		out.println("Value of session : " + sesMesg + "<br>");
		out.println("Value of request : " + reqMesg + "<br>");
	}
}
