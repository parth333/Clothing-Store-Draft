package service;

import java.util.List;

import dao.UserDAO;
import dto.User;


public class UserServiceImpl implements UserService {
	
	
	private UserDAO userDao;
	
	
	
	@Override
	public User getUser(String email) {
		return userDao.getUser(email);
	}

	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
		
	}

	@Override
	public boolean delUser(String email) {
		return userDao.delUser(email);
	}

	@Override
	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public boolean checkByName(User user) {
		return userDao.checkByName(user);
	}

}
