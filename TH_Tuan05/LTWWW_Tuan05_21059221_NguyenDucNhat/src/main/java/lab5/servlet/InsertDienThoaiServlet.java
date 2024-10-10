package lab5.servlet;

import lab5.daoImpl.DienThoaiDAOImpl;
import lab5.model.DienThoai;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.sql.SQLException;

@MultipartConfig
public class InsertDienThoaiServlet extends HttpServlet {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String maDT = request.getParameter("maDT");
		String tenDT = request.getParameter("tenDT");
		int namSanXuat = Integer.parseInt(request.getParameter("namSanXuat"));
		String cauHinh = request.getParameter("cauHinh");
		String maNCC = request.getParameter("maNCC");
		Part hinhAnhPart = request.getPart("hinhAnh");
		String fileName = hinhAnhPart.getSubmittedFileName();

		// Lưu file hình ảnh vào thư mục
		String uploadPath = getServletContext().getRealPath("/") + "images/" + fileName;
		hinhAnhPart.write(uploadPath);

		DienThoai dienThoai = new DienThoai(maDT, tenDT, namSanXuat, cauHinh, maNCC, "images/" + fileName);

		try {
			dienThoaiDAO.insertDienThoai(dienThoai);
			response.sendRedirect("danhSachDienThoai");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
