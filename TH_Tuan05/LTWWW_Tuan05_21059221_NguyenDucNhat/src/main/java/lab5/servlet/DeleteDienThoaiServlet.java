package lab5.servlet;

import lab5.daoImpl.DienThoaiDAOImpl;
import lab5.utils.EntityManagerFactoryUtil;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DeleteDienThoaiServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DienThoaiDAOImpl dienThoaiDAO;
	private EntityManagerFactoryUtil entityManageFactory;

	public DeleteDienThoaiServlet() {
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

		dienThoaiDAO.deleteDienThoai(maDT);
		response.sendRedirect("ddanhSachDienThoai");
	}
}
