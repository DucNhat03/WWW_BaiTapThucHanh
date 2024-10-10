package controller;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dao.Product_DAO;
import daoimp.Product_Implement;
import entities.Item;
import entities.Product;

public class cartControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/shopping")
	private DataSource data;
	private Product_DAO dao;   

    public cartControl() {
        super();
    }

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = new Product_Implement(data);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Product p = dao.getById(id);
		int quantity = 1;
		
		HttpSession session = request.getSession();
		
		@SuppressWarnings("unchecked")
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		   if (cart == null) {
		        cart = new ArrayList<>();
		    }
		   
		   boolean productExists = false;
		    for (Item item : cart) {
		        if (item.getProduct().getId().equals(p.getId())) {
		            
		            item.setQuantity(item.getQuantity() + 1);
		            productExists = true;
		            break;
		        }
		    }
		    
		    if (!productExists) {
		    	Item i = new Item(p, quantity);
		        cart.add(i);
		    }
		    
		    session.setAttribute("cart", cart);
		    response.sendRedirect("view/cart.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
