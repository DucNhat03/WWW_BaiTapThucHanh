package iuh.filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class MIMETypeChainFilter
 */
@WebFilter("/*") // Ánh xạ tất cả các URL
public class MIMETypeChainFilter extends HttpFilter implements Filter {

	public MIMETypeChainFilter() {
		super();
	}

	@Override
	public void destroy() {
		// Giải phóng tài nguyên nếu cần
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletResponse res = (HttpServletResponse) response;

		// Thay đổi MIME type nếu cần
		if (res.getContentType() != null && res.getContentType().equals("text/html")) {
			res.setContentType("application/json");
		}

		chain.doFilter(request, res);
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// Khởi tạo tài nguyên nếu cần
	}
}
