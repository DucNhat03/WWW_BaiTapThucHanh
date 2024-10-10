package controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TinTuc;
import utils.EntityManagerFactoryUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.TinTucDAO;
import daoImpl.TinTucDAOImpl;

public class DanhSachTinTucServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactoryUtil entityManageFactory;
	private TinTucDAO tinTucDAO;

	public DanhSachTinTucServlet() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
        this.entityManageFactory = new EntityManagerFactoryUtil();
		this.tinTucDAO = new TinTucDAOImpl(this.entityManageFactory.getEnManager());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<TinTuc> tinTucList = tinTucDAO.getAllTinTuc();
			request.setAttribute("tinTucList", tinTucList);
			request.getRequestDispatcher("DanhSachTinTuc.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
	}

	@Override
	public void destroy() {
		this.entityManageFactory.close();
		super.destroy();
	}
}
