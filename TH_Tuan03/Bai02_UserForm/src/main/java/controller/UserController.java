package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import entities.User;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String fname = request.getParameter("firstName");
		String lname = request.getParameter("lastName");
		String email = request.getParameter("email");
		String reEmail = request.getParameter("re-email");
		String pass = request.getParameter("password");
		String gender = request.getParameter("gender");
		String day = request.getParameter("day");
		String month = request.getParameter("month");
		String year = request.getParameter("year");
		String birthDay = day + "/" + month + "/" + year;

		boolean gen = false;
		if (gender.equals("female")) {
			gen = true;
		}
		User User = new User(fname, lname, email, pass, birthDay, gen);
		System.out.println(User);

		PrintWriter out = response.getWriter();

		if (email.equals(reEmail)) {
			out.println("<html><body>");
			out.println("<h2>User Information</h2>");
			out.println("<p>First Name: " + User.getFirstName() + "</p>");
			out.println("<p>Last Name: " + User.getLastName() + "</p>");
			out.println("<p>Email: " + User.getEmail() + "</p>");
			out.println("<p>Gender: " + gender + "</p>");
			out.println("<p>Birth Date: " + User.getBirthDay() + "</p>");
			out.println("</body></html>");
		} else {
			out.println("<html><body>");
			out.println("EMAIL WRONG");
			out.println("</body></html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
