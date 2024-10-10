package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import entities.Student;

public class formController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public formController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String fname = request.getParameter("firstName");
		String lname = request.getParameter("lastName");
		String day = request.getParameter("day");
		String month = request.getParameter("month");
		String year = request.getParameter("year");
		String birthDay = day + "/" + month + "/" + year;
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String pincode = request.getParameter("pinCode");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String hobbies = request.getParameter("hobbies");
		String course = request.getParameter("course");

		boolean gen = true;
		if (gender.equals("female")) {
			gen = false;
		} else {
			gen = true;
		}

		Student stu = new Student(fname, lname, birthDay, email, phone, gen, address, city, pincode, state, country,
				hobbies, null, course);

		request.setAttribute("s", stu);
		request.getRequestDispatcher("result-form.jsp").forward(request, response);
	}

	// Ví dụ trong Servlet
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
