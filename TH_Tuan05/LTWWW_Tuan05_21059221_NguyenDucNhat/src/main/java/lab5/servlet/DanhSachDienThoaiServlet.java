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
import java.util.List;

public class DanhSachDienThoaiServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManagerFactoryUtil entityManageFactory;
	private DienThoaiDAOImpl dienThoaiDAO;

	public DanhSachDienThoaiServlet() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.entityManageFactory = new EntityManagerFactoryUtil();
		this.dienThoaiDAO = new DienThoaiDAOImpl(this.entityManageFactory.getEnManager());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<DienThoai> dsDienThoai = dienThoaiDAO.getAllDienThoai();
		request.setAttribute("dsDienThoai", dsDienThoai);
		request.getRequestDispatcher("danhSachDienThoai.jsp").forward(request, response);

	}

	@Override
	public void destroy() {
		this.entityManageFactory.close();
		super.destroy();
	}

}
