package controller;

import dao.ProductDAO;
import daoImpl.ProductDAOImpl;
import model.CartItem;
import model.Product;
import utils.EntityManagerFactoryUtil;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@WebServlet("/addToCart")
@SuppressWarnings("unchecked")
public class AddToCartServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EntityManagerFactoryUtil entityManageFactory;
	private ProductDAO productDAO;

	public AddToCartServlet() {
		super();

	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.entityManageFactory = new EntityManagerFactoryUtil();
		this.productDAO = new ProductDAOImpl(this.entityManageFactory.getEnManager());
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		this.entityManageFactory.close();
		super.destroy();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("productId"));
		Product product = productDAO.findProductById(productId);

		HttpSession session = request.getSession();
		List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
		if (cart == null) {
			cart = new ArrayList<>();
		}

		boolean found = false;
		for (CartItem item : cart) {
			if (item.getProduct().getId() == productId) {
				item.setQuantity(item.getQuantity() + 1);
				found = true;
				break;
			}
		}

		if (!found) {
			cart.add(new CartItem(product, 1));
		}

		session.setAttribute("cart", cart);
		response.sendRedirect("viewCart");
	}
}
