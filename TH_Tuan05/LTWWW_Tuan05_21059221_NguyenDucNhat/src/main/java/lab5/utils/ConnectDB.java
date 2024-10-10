package lab5.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

	private static final String JDBC_URL = "jdbc:mariadb://localhost:3306/quanlydienthoai"; 
	private static final String JDBC_USERNAME = "root";
	private static final String JDBC_PASSWORD = "sapassword"; 

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("org.mariadb.jdbc.Driver"); 
			System.out.println("MariaDB JDBC Driver loaded successfully!");
		} catch (ClassNotFoundException e) {
			System.out.println("Error loading MariaDB JDBC Driver");
			e.printStackTrace();
		}

		System.out.println("Connecting to database...");
		Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
		System.out.println("Database connected successfully!"); 
		return connection;
	}
}
