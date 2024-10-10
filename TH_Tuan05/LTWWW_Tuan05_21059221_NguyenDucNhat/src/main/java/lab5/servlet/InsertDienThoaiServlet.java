package lab5.servlet;

import lab5.daoImpl.DienThoaiDAOImpl;
import lab5.model.DienThoai;
import lab5.utils.EntityManagerFactoryUtil;
import jakarta.servlet.ServletConfig;
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
	private EntityManagerFactoryUtil entityManageFactory;
	private DienThoaiDAOImpl dienThoaiDAO;

	public InsertDienThoaiServlet() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.entityManageFactory = new EntityManagerFactoryUtil();
		this.dienThoaiDAO = new DienThoaiDAOImpl(this.entityManageFactory.getEnManager());
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

		dienThoaiDAO.insertDienThoai(dienThoai);
		response.sendRedirect("ddanhSachDienThoai");
	}

}
