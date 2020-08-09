package sec12.ex01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class EncoderFilter implements Filter {
	ServletContext context;

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("utf-8 encoding..........");
		context = fConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Call doFilter method");
		request.setCharacterEncoding("utf-8");

		String context = ((HttpServletRequest) request).getContextPath();
		String pathinfo = ((HttpServletRequest) request).getRequestURI();
		String mesg = " Context: " + context + "\n URI: " + pathinfo;
		System.out.println(mesg);

		long begin = System.currentTimeMillis();
		chain.doFilter(request, response);
		long end = System.currentTimeMillis();
		System.out.println(" Processing Time: " + (end - begin) + "ms");
	}

	@Override
	public void destroy() {
	}

}
