package springBootConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import dao.EmployeeDAO;
import entities.Employee;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringPureJdbcAutoConfigApplication.class);

		EmployeeDAO employeeDAO = context.getBean(EmployeeDAO.class);
		System.out.println("Lấy được EmployeeDAO bean thành công!");

		Employee employee = new Employee("Nguyen Duc Nhat", "Developer");
		employeeDAO.save(employee);

		employeeDAO.getAll().forEach(System.out::println);
	}
}
