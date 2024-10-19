package dao;

import java.util.List;

import entities.Employee;

public interface EmployeeDAO {
	List<Employee> getAll();

	Employee getById(int id);

	void save(Employee employee);

	void update(Employee employee);

	void deleteById(int id);
}
