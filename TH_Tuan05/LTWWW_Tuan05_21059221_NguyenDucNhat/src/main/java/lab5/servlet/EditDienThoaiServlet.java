package lab5.servlet;

import lab5.daoImpl.DienThoaiDAOImpl;
import lab5.model.DienThoai;
import lab5.utils.EntityManagerFactoryUtil;
import jakarta.servlet.ServletConfig;
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
	private EntityManagerFactoryUtil entityManageFactory;
	private DienThoaiDAOImpl dienThoaiDAO;

	public EditDienThoaiServlet() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.entityManageFactory = new EntityManagerFactoryUtil();
		this.dienThoaiDAO = new DienThoaiDAOImpl(this.entityManageFactory.getEnManager());
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Lấy mã điện thoại từ query string
		String maDT = request.getParameter("maDT");

		// Lấy thông tin điện thoại từ cơ sở dữ liệu
		DienThoai dienThoai = dienThoaiDAO.getDienThoaiById(maDT);

		// Kiểm tra nếu tồn tại điện thoại
		if (dienThoai != null) {
			// Đưa thông tin điện thoại vào request và chuyển đến trang chỉnh sửa
			request.setAttribute("dienThoai", dienThoai);
			request.getRequestDispatcher("editDienThoai.jsp").forward(request, response);
		} else {
			// Nếu không tìm thấy sản phẩm, chuyển đến trang lỗi hoặc danh sách
			response.sendRedirect("ddanhSachDienThoai");
		}
	}
}
