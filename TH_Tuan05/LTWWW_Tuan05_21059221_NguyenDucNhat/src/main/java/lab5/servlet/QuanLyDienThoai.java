package lab5.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lab5.daoImpl.DienThoaiDAOImpl;
import lab5.utils.EntityManagerFactoryUtil;
import lab5.model.DienThoai;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class QuanLyDienThoai extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactoryUtil entityManageFactory;
	private DienThoaiDAOImpl dienThoaiDAO;

	public QuanLyDienThoai() {
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
		List<DienThoai> dienThoaiList = dienThoaiDAO.getAllDienThoai();
		request.setAttribute("dienThoaiList", dienThoaiList);
		request.getRequestDispatcher("quanLyDienThoai.jsp").forward(request, response);
	}

}
