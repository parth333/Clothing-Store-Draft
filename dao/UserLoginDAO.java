package dao;

import java.util.ArrayList;
import java.util.List;

import dto.Product;
import dto.User;

public class UserLoginDAO {

	//check whether user exists in a database table by supplying from jsp potential-user credentials, userName and password																																																																																																																																																																																																																																																				
		public boolean checkLogin(String userName, String password){
			//instantiate a User object
			User user = new User();
			//instantiate a UserDAOImpl object
			UserDAO userDao = new UserDAOImpl();
			//set user credentials as states of the user object for querying the database with said credentials in an attempt to authenticate the user
			user.setUserName(userName);
			user.setPassword(password);
			//return boolean depending on user user authentication
			return userDao.checkByName(user);
		}

		//retrieve userName state of an authenticated user from the database 
		public User getUser(String userName){
			//instantiate User and UserDAOImpl object for database query of already existing userName 
			User user = new User();
			UserDAO userDao = new UserDAOImpl();
			//get userName from a table
			user = userDao.getUser(userName);	
			return user;
		}

	//Show names of all the products available in the shop
		public List<Product> showProducts(){
			
			//Instantiate an ArrayList of Product objects;
			List<Product> lp = new ArrayList<>();
			
			//Instantiate a new ProductDAOImpl object to use the class' getAllProduct method;
			ProductDAO pDao = new ProductDAOImpl();
			
			//populate lp with returned list of all product names;
			lp = pDao.getAllProducts();
			
			return lp;
		}

}
