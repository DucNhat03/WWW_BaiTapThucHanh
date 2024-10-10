package lab5.servlet;

import lab5.daoImpl.DienThoaiDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

public class DeleteDienThoaiServlet extends HttpServlet {
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

		try {
			dienThoaiDAO.deleteDienThoai(maDT);
			response.sendRedirect("danhSachDienThoai");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
