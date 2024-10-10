package controller;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import entities.Item;


public class removeControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public removeControl() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id").trim();
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		int index = isProductExisting(Integer.parseInt(id), cart);
		if(index != -1) {
			cart.remove(index);
			session.setAttribute("cart", cart);
			response.sendRedirect("view/cart.jsp");
		}
		
	}
	
	private int isProductExisting(int id, List<Item> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (Integer.parseInt(cart.get(i).getProduct().getId()) == id) {
				return i;
			}
		}
		return -1;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
