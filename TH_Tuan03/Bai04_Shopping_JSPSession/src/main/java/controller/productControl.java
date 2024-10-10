package controller;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import dao.Product_DAO;
import daoimp.Product_Implement;
import entities.Product;

public class productControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name="jdbc/shopping")
	private DataSource data;
	private Product_DAO dao;
    public productControl() {
        super();

    }

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = new Product_Implement(data);
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product p1 = new Product("Cookie 1", 5000, "blue.png");
		dao.addProduct(p1);
		Product p2 = new Product("Cookie 2", 10000, "pink.png");
		dao.addProduct(p2);
		Product p3 = new Product("Cookie 3", 15000, "orange.png");
		dao.addProduct(p3);
		Product p4 = new Product("Cookie 4", 20000, "red.png");
		dao.addProduct(p4);
		List<Product> lst = dao.findAll();
		request.setAttribute("lst", lst);
		request.getRequestDispatcher("view/product.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
