package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import entities.Employee;
import javaBasedConfiguration.JavaConfig;

public class Main_JavaConfig {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

        Employee employee = context.getBean(Employee.class);
        System.out.println(employee);
    }
}