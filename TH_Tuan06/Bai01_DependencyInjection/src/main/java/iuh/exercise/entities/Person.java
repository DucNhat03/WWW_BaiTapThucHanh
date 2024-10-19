package iuh.exercise.entities;

import java.util.List;

public class Person {
	private int age;
	private String name;
	private List<String> emails;
	private List<Address> address;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(int age, String name, List<String> emails, List<Address> address) {
		super();
		this.age = age;
		this.name = name;
		this.emails = emails;
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", emails=" + emails + ", address=" + address + "]";
	}

}
