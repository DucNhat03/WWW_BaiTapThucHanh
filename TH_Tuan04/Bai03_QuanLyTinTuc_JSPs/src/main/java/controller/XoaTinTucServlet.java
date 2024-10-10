package controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.EntityManagerFactoryUtil;

import java.io.IOException;
import java.sql.SQLException;

import dao.TinTucDAO;
import daoImpl.TinTucDAOImpl;

@WebServlet("/XoaTinTucServlet")
public class XoaTinTucServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EntityManagerFactoryUtil entityManageFactory;
	private TinTucDAO tinTucDAO;

	public XoaTinTucServlet() {
		super();

	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.entityManageFactory = new EntityManagerFactoryUtil();
		this.tinTucDAO = new TinTucDAOImpl(this.entityManageFactory.getEnManager());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int maTT = Integer.parseInt(request.getParameter("maTT"));
		try {
			tinTucDAO.deleteTinTuc(maTT);
			response.sendRedirect("danhSachTinTuc");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		this.entityManageFactory.close();
		super.destroy();
	}

}
