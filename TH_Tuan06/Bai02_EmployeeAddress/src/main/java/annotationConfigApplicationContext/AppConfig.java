package annotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import entities.Address;
import entities.Employee;

@Configuration
public class AppConfig {

    @Bean
    public Address address() {
        return new Address("Ngô Mây", "Quy Nhơn", "Bình Định");
    }

    @Bean
    public Employee employee() {
        return new Employee(2, "Nguyễn Đức Nhật", address());
    }
}

