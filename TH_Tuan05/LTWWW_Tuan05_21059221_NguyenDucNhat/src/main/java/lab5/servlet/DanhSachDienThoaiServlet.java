package lab5.servlet;

import lab5.daoImpl.DienThoaiDAOImpl;
import lab5.model.DienThoai;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DanhSachDienThoaiServlet extends HttpServlet {

    private DienThoaiDAOImpl dienThoaiDAO;

    public void init() {
        dienThoaiDAO = new DienThoaiDAOImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<DienThoai> dsDienThoai = dienThoaiDAO.getAllDienThoai();
            request.setAttribute("dsDienThoai", dsDienThoai);  // Chuyển danh sách điện thoại sang JSP
            request.getRequestDispatcher("danhSachDienThoai.jsp").forward(request, response);  
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Lỗi kết nối cơ sở dữ liệu");
//            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
