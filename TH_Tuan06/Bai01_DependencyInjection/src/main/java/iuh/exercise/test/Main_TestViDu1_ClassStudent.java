package iuh.exercise.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import iuh.exercise.entities.Student;

public class Main_TestViDu1_ClassStudent {
	private static ApplicationContext context;
	public static void main(String[] args) {
		
		// --------------- Ví dụ 01:
//		context = new ClassPathXmlApplicationContext("beans.xml");
//		Student student = (Student) context.getBean("student1");
//		System.out.println(student);
		
		// --------------- Ví dụ 02:
//		context = new ClassPathXmlApplicationContext("beans.xml");
//		Student student2 = (Student) context.getBean("student2");
//		System.out.println(student2);
//		
		// --------------- Ví dụ 03:
		context = new ClassPathXmlApplicationContext("beans.xml");
		Student student3 = (Student) context.getBean("student3");
		System.out.println(student3);
		
	}
}
