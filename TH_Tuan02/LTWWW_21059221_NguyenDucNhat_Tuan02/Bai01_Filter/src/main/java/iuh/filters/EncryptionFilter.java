package iuh.filters;

import java.io.IOException;
import java.util.Base64;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class EncryptionFilter
 */
@WebFilter("/*") // Ánh xạ tất cả các URL
public class EncryptionFilter extends HttpFilter implements Filter {

	public EncryptionFilter() {
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

		// Mã hóa dữ liệu request
		String user = req.getParameter("userName");
		if (user != null) {
			String encryptedUser = Base64.getEncoder().encodeToString(user.getBytes());
			req.setAttribute("encryptedUser", encryptedUser);
		}

		chain.doFilter(req, res);

		// Mã hóa dữ liệu response
		String content = res.getContentType();
		if (content != null && content.contains("text/html")) {
			// Xử lý mã hóa thêm nếu cần thiết cho response
		}
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// Khởi tạo tài nguyên nếu cần
	}
}
