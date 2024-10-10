import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/quanlydienthoai", "root",
					"sapassword");
			if (conn != null) {
				System.out.println("Successfully connected to the database!");
			} else {
				System.out.println("Failed to connect to the database.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
