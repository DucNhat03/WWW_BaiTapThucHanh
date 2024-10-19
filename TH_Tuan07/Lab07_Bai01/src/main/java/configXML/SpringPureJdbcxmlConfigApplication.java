package configXML;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class SpringPureJdbcxmlConfigApplication {
    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("databaseConfig.xml");
        DataSource dataSource = context.getBean("dataSource", DataSource.class);

        try (Connection connection = dataSource.getConnection()) {
            System.out.println("Kết nối thành công: " + connection.getMetaData().getURL());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Kết nối thất bại!");
        }
    }
}
