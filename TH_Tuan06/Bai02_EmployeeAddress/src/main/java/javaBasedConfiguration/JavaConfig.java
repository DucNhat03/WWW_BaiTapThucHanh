package javaBasedConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import entities.Address;
import entities.Employee;

@Configuration
public class JavaConfig {

    @Bean
    public Address address() {
        return new Address("Lê Lợi", "Quy Nhơn", "Bình Định");
    }

    @Bean
    public Employee employee(Address address) {
        return new Employee(3, "Nguyễn Đức Nhật", address);
    }
}

