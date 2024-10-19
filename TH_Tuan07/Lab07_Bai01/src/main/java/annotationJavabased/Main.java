package annotationJavabased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        DataSource dataSource = context.getBean(DataSource.class);

        try (Connection connection = dataSource.getConnection()) {
            System.out.println("Kết nối thành công: " + connection.getMetaData().getURL());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Kết nối thất bại!");
        }
    }
}

