package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import annotationConfigApplicationContext.AppConfig;
import entities.Employee;

public class Main_AppConfig {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Employee employee = context.getBean(Employee.class);
        System.out.println(employee);
    }
}

