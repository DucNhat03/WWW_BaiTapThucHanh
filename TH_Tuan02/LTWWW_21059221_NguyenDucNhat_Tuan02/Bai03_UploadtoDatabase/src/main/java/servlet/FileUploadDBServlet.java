package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection;

/**
 * Servlet implementation class FileUploadDBServlet
 */
@MultipartConfig
public class FileUploadDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int BUFFER_SIZE = 4096;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileUploadDBServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String firstName = request.getParameter("firstName");
	    String lastName = request.getParameter("lastName");

	    // Kiểm tra giá trị nhận từ form
	    System.out.println("First Name: " + firstName);
	    System.out.println("Last Name: " + lastName);

	    InputStream inputStream = null;
	    Part filePart = request.getPart("photo");
	    String fileUploadName = "";

//	    if (filePart != null && filePart.getSubmittedFileName() != null && !filePart.getSubmittedFileName().isEmpty()) {
//	        fileUploadName = filePart.getSubmittedFileName();
//	        inputStream = filePart.getInputStream();
//	    }
	    
	    if (filePart != null && filePart.getSubmittedFileName() != null && !filePart.getSubmittedFileName().isEmpty()) {
	        fileUploadName = filePart.getSubmittedFileName();
	        inputStream = filePart.getInputStream();
	    } else {
	        System.out.println("FilePart is null or empty.");
	    }


	    // Kiểm tra nếu inputStream có giá trị
	    if (inputStream == null) {
	        System.out.println("InputStream is null.");
	    } else {
	        System.out.println("InputStream is not null.");
	    }

	    Connection conn = null;
	    String message = null;

	    try {
	        conn = DBConnection.getConnection();
	        String sqlInsert = "INSERT INTO contacts (first_name, last_name, photo) values (?, ?, ?)";
	        PreparedStatement statement = conn.prepareStatement(sqlInsert);
	        statement.setString(1, firstName);
	        statement.setString(2, lastName);

//	        if (inputStream != null) {
//	            statement.setBlob(3, inputStream);
//	        } else {
//	            statement.setNull(3, java.sql.Types.BLOB);
//	        }
	        
	        if (inputStream != null) {
	            System.out.println("Saving image to database...");
	            statement.setBlob(3, inputStream);
	        } else {
	            System.out.println("No image provided, setting as NULL.");
	            statement.setNull(3, java.sql.Types.BLOB);
	        }


	        int row = statement.executeUpdate();
	        if (row > 0) {
	            message = "File uploaded and saved into the database";
	        }

	    } catch (SQLException ex) {
	        message = "ERROR: " + ex.getMessage();
	        ex.printStackTrace();
	    } finally {
	        if (conn != null) {
	            try {
	                conn.close();
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	        }
	        request.setAttribute("Message", message);
	        getServletContext().getRequestDispatcher("/MessageServlet").forward(request, response);
	    }
	}



}
