package lab5.servlet;

import lab5.daoImpl.DienThoaiDAOImpl;
import lab5.model.DienThoai;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

public class EditDienThoaiServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DienThoaiDAOImpl dienThoaiDAO;

	@Override
	public void init() {
		dienThoaiDAO = new DienThoaiDAOImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Lấy mã điện thoại từ query string
		String maDT = request.getParameter("maDT");

		try {
			// Lấy thông tin điện thoại từ cơ sở dữ liệu
			DienThoai dienThoai = dienThoaiDAO.getDienThoaiById(maDT);

			// Kiểm tra nếu tồn tại điện thoại
			if (dienThoai != null) {
				// Đưa thông tin điện thoại vào request và chuyển đến trang chỉnh sửa
				request.setAttribute("dienThoai", dienThoai);
				request.getRequestDispatcher("editDienThoai.jsp").forward(request, response);
			} else {
				// Nếu không tìm thấy sản phẩm, chuyển đến trang lỗi hoặc danh sách
				response.sendRedirect("danhSachDienThoai");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("danhSachDienThoai");
		}
	}
}
