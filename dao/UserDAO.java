package dao;

import java.util.List;

import dto.User;

//User DAO interface for carrying out CRUD operations on the 'User' (customer) object;
public interface UserDAO {
	//method declaration to retrieve 'User' instance (database table row) given the user's name; 
	public User getUser(String name);
	//method declaration to retrieve a list of 'User' objects;
	public List<User> getAllUser();
	//method declaration to insert a new 'User' into the table;
	public void addUser(User user);
	//method declaration to remove a 'User' row from table;
	public boolean delUser(String email);
	//method declaration to change particular state (column within a row) of a 'User'; 
	public boolean updateUser(User user);
	//method declaration to read/check table for finding a 'User';
	public boolean checkByName(User user);
	//method declaration to read/check table for finding a 'User' by name, while allowing various state for a given name;
	public boolean checkExisting(String name);
}
