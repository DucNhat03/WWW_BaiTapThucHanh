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
public class UpdateDienThoaiServlet extends HttpServlet {
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

		// Nếu không chọn ảnh mới, giữ lại ảnh cũ
		String fileName = hinhAnhPart.getSize() > 0 ? hinhAnhPart.getSubmittedFileName() : null;

		if (fileName != null) {
			// Lưu file hình ảnh vào thư mục
			String uploadPath = getServletContext().getRealPath("/") + "images/" + fileName;
			hinhAnhPart.write(uploadPath);
		}

		try {
			DienThoai dienThoai = dienThoaiDAO.getDienThoaiById(maDT);
			dienThoai.setTenDT(tenDT);
			dienThoai.setNamSanXuat(namSanXuat);
			dienThoai.setCauHinh(cauHinh);
			dienThoai.setMaNCC(maNCC);

			if (fileName != null) {
				dienThoai.setHinhAnh("images/" + fileName);
			}

			dienThoaiDAO.updateDienThoai(dienThoai);
			response.sendRedirect("danhSachDienThoai");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
