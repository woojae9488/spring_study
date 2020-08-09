package sec08.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login4")
public class LoginServlet extends HttpServlet {
	public void init() {
		System.out.println("Call init method");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_address = request.getParameter("user_address");
		String user_email = request.getParameter("user_email");
		String user_hp = request.getParameter("user_hp");

		String data = "Hello!<br> You have been login.<br><br>";
		data += "<html><body>";
		data += "Id : " + user_id;
		data += "<br>";
		data += "Password : " + user_pw;
		data += "<br>";
		data += "Address : " + user_address;
		data += "<br>";
		data += "Email : " + user_email;
		data += "<br>";
		data += "Phone : " + user_hp;
		data += "</html></body>";
		out.print(data);

		user_address = URLEncoder.encode(user_address, "utf-8");
		out.print("<a href='/WebServletPrj/sec?user_id=" + user_id + "&user_pw=" + user_pw + "&user_address="
				+ user_address + "'>Send to SecondServlet</a>");
		data = "</body></html>";
		out.print(data);
	}

	public void destroy() {
		System.out.println("Call destroy method");
	}
}
