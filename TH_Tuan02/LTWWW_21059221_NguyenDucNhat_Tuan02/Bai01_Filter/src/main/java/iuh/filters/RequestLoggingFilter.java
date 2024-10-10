package iuh.filters;

import java.io.IOException;
import java.util.Enumeration;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter("/*") // Ánh xạ tất cả các URL
public class RequestLoggingFilter extends HttpFilter implements Filter {

	private ServletContext context;

	public RequestLoggingFilter() {
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
		Enumeration<String> params = req.getParameterNames();
		while (params.hasMoreElements()) {
			String name = params.nextElement();
			String value = request.getParameter(name);
			this.context.log(req.getRemoteAddr() + " :Request Params: {" + name + "=" + value + "}");
		}

		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				this.context
						.log(req.getRemoteAddr() + " :Cookie: {" + cookie.getName() + "," + cookie.getValue() + "}");
			}
		}

		chain.doFilter(request, response); // Tiếp tục thực thi filter hoặc servlet tiếp theo
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("RequestLoggingFilter initialized");
	}
}
