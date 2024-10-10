import java.sql.Connection;
import java.sql.SQLException;

import lab5.utils.ConnectDB;

public class TestConnection {

    public static void main(String[] args) {
        try {
            Connection conn = ConnectDB.getConnection();
            if (conn != null) {
                System.out.println("Kết nối đến cơ sở dữ liệu thành công!");
                conn.close();  // Đóng kết nối sau khi hoàn thành
            }
        } catch (SQLException e) {
            System.err.println("Kết nối đến cơ sở dữ liệu thất bại.");
            e.printStackTrace();
        }
    }
}
