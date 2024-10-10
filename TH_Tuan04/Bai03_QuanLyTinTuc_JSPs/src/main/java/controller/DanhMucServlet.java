package controller;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DanhMuc;
import utils.EntityManagerFactoryUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.DanhMucDAO;
import daoImpl.DanhMucDAOImpl;

public class DanhMucServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManagerFactoryUtil entityManageFactory;
	private DanhMucDAO danhMucDAO;

	public DanhMucServlet() {
		super();

	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.entityManageFactory = new EntityManagerFactoryUtil();
		this.danhMucDAO = new DanhMucDAOImpl(this.entityManageFactory.getEnManager());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<DanhMuc> danhMucList;
		try {
			danhMucList = danhMucDAO.getAllDanhMuc();
			request.setAttribute("danhMucList", danhMucList);
			request.getRequestDispatcher("DanhSachDanhMuc.jsp").forward(request, response);
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
