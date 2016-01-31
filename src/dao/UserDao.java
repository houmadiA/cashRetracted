package dao;

import java.util.List;

import model.User;

public interface UserDao {

	public void add(User user);
	public void delete(Integer id);
	public User getById(Integer id);
	public User getByUsername(String username);
	public void update(User user);
	public List<User> getAll();
}
