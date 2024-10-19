package daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import dao.EmployeeDAO;
import entities.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public EmployeeDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Employee> getAll() {
		String sql = "SELECT * FROM employees";
		return jdbcTemplate.query(sql, new EmployeeRowMapper());
	}

	@Override
	public Employee getById(int id) {
		String sql = "SELECT * FROM employees WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), id);
	}

	@Override
	public void save(Employee employee) {
		String sql = "INSERT INTO employees (name, role) VALUES (?, ?)";
		jdbcTemplate.update(sql, employee.getName(), employee.getRole());
	}

	@Override
	public void update(Employee employee) {
		String sql = "UPDATE employees SET name = ?, role = ? WHERE id = ?";
		jdbcTemplate.update(sql, employee.getName(), employee.getRole(), employee.getId());
	}

	@Override
	public void deleteById(int id) {
		String sql = "DELETE FROM employees WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}

	private static class EmployeeRowMapper implements RowMapper<Employee> {
		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("role"));
		}
	}
}
