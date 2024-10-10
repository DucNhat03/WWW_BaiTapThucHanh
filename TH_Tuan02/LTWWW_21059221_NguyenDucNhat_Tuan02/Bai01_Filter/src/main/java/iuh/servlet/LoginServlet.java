package iuh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final String userID = "admin";
    private final String password = "password";

    /**
     * Xử lý POST request cho đăng nhập
     */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Lấy các tham số từ request (userName và password)
        String user = request.getParameter("userName");
        String pwd = request.getParameter("password");

        // Kiểm tra thông tin đăng nhập
        if (userID.equals(user) && password.equals(pwd)) {
            HttpSession session = request.getSession();
            session.setAttribute("userIdSession", userID);
            session.setMaxInactiveInterval(30 * 60); // Phiên làm việc sẽ hết hạn sau 30 phút

            Cookie cookieUserName = new Cookie("userIdCookie", userID);
            cookieUserName.setMaxAge(30 * 60); // Cookie sẽ hết hạn sau 30 phút
            response.addCookie(cookieUserName);

            response.sendRedirect("login_success.jsp");

        } else {
            // Nếu đăng nhập thất bại, quay lại trang login với thông báo lỗi
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = response.getWriter();
            out.println("<font color='red'>User name or password is wrong.</font>");
            rd.include(request, response);
        }
    }
}
