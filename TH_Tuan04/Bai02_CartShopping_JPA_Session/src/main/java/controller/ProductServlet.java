package controller;

import dao.ProductDAO;
import daoImpl.ProductDAOImpl;
import model.Product;
import utils.EntityManagerFactoryUtil;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

//@WebServlet("/productList")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EntityManagerFactoryUtil entityManageFactory;
	private ProductDAO productDAO;

	public ProductServlet() {
		super();

	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.entityManageFactory = new EntityManagerFactoryUtil();
		this.productDAO = new ProductDAOImpl(this.entityManageFactory.getEnManager());
	}

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Product> products = productDAO.getAllProducts();

		request.setAttribute("products", products);

		request.getRequestDispatcher("jsp/product.jsp").forward(request, response);
	}
	
	
	@Override
	public void destroy() {
		this.entityManageFactory.close();
		super.destroy();
	}
}
