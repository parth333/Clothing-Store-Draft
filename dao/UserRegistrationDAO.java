package dao;

import dto.User;

public class UserRegistrationDAO {
	
	//attempt to register a potential-user in case the data does not exist in the database;
		public boolean insertNewUser(String userName, String email, String password){
			//instantiate User and UserDAOImpl object for database query;
			User user = new User();
			UserDAO  userDao = new UserDAOImpl();
			
			//Assign states to User object;
			user.setUserName(userName);
			user.setEmail(email);
			user.setPassword(password);
			
			//Check whether the user exists in the database using the userDao object's checkExisting method which takes the userName;
			if(userDao.checkExisting(userName)){
				//return false for an existing userName in database;
				return false;
			}else{
				//else add user to database and return true;
				userDao.addUser(user);
				return true;
			}
		}
}
