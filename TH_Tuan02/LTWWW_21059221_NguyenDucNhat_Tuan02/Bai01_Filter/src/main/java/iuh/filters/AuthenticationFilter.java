package iuh.filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*") // Ánh xạ tất cả các URL
public class AuthenticationFilter extends HttpFilter implements Filter {

	private ServletContext context;

	public AuthenticationFilter() {
		super();
	}

	@Override
	public void destroy() {
		// Giải phóng tài nguyên nếu cần
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String uri = req.getRequestURI();
		this.context.log("Requested Resource: " + uri);

		HttpSession session = req.getSession(false);

		if (session == null && !(uri.endsWith("html") || uri.endsWith("login"))) {
			this.context.log("Unauthorized access request");
			res.sendRedirect("login.html");
		} else {
			chain.doFilter(request, response); // Tiếp tục thực thi filter hoặc servlet tiếp theo
		}
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("AuthenticationFilter initialized");
	}
}
