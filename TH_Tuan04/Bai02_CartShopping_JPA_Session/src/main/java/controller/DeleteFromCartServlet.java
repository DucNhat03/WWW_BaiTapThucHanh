package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
import model.CartItem;

//@WebServlet("/deleteFromCart")
@SuppressWarnings("unchecked")
public class DeleteFromCartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("productId"));

		HttpSession session = request.getSession();

		List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
		cart.removeIf(item -> item.getProduct().getId() == productId);

		session.setAttribute("cart", cart);
		response.sendRedirect("viewCart");
	}
}
