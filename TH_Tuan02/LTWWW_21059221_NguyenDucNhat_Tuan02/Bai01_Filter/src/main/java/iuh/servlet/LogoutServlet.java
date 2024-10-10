package iuh.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Xử lý POST request cho đăng xuất
     */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        // Xóa tất cả các cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                Cookie cookieUserName = new Cookie(cookie.getName(), "");
                cookieUserName.setMaxAge(0);
                response.addCookie(cookieUserName);
            }
        }

        // Hủy bỏ phiên làm việc nếu có
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        // Chuyển hướng về trang login
        response.sendRedirect("login.html");
    }
}
