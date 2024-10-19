package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entities.Employee;

public class Main {
	private static ApplicationContext context;
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("beans.xml");
		Employee employee = (Employee) context.getBean("employee02");
		System.out.println(employee);
	}
}
