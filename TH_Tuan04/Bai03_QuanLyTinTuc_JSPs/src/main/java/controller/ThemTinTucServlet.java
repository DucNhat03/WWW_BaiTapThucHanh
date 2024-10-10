package controller;

import jakarta.persistence.EntityManager;
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

import dao.DanhMucDAO;
import dao.TinTucDAO;
import daoImpl.DanhMucDAOImpl;
import daoImpl.TinTucDAOImpl;

public class ThemTinTucServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EntityManagerFactoryUtil entityManageFactory;
	private TinTucDAO tinTucDAO;
	private DanhMucDAO danhMucDAO;

	public ThemTinTucServlet() {
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
		String tieuDe = request.getParameter("tieuDe");
		String noiDungTT = request.getParameter("noiDungTT");
		String lienKet = request.getParameter("lienKet");
//		int maDM = Integer.parseInt(request.getParameter("maDM"));
		int num = 0;
		try {
			num = tinTucDAO.getAllTinTuc().size();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int maTT = num + 1;
		int maDM = 1;

		TinTuc tinTuc = new TinTuc(maTT, tieuDe, noiDungTT, lienKet, maDM);
		try {
			tinTucDAO.addTinTuc(tinTuc);
			response.sendRedirect("danhSachTinTuc?maDM=" + maDM);
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
