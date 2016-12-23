package dao;

import java.util.List;

import dto.User;

public interface UserDAO {
	public User getUser(String id);
	public List<User> getAllUser();
	public void addUser(User user);
	public boolean delUser(String id);
	public boolean updateUser(User user);
}
