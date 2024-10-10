package dao;

import java.util.List;

import entities.User;

public interface UserDAO {

	public User save(User user);

	public User update(User user);

	public List<User> findAll();
}
