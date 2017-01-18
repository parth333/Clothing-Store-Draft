package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserLoginService;

import dao.ProductDAO;
import dao.ProductDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import dto.Product;
import dto.User;
import exception.ApplicationException;

//the servlet associated with this controller receives the username and password from 'login.jsp' in order to authenticate

public class LoginController {
	
	//instantiate a service layer object
	UserLoginService uLS = new UserLoginService();

	//processRequest method to process received parameters from the jsp
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		//do back-end check on hidden parameters prior to begining of processing work to potentially save time in case wrong ones are received by the servlet
		String action = request.getParameter("tryLogin");

		//check values of the received parameter
		if(action.equalsIgnoreCase("login")){
			
			//receive the username and password
			String userName = request.getParameter("username");
			String password = request.getParameter("password");
			
			//Create a new User object
			User user = null;
			
			//If there exists a session object then reference it, otherwise create a new session object
			HttpSession session = request.getSession(true);
			
			try{
			//Check the username and password for the purpose of user authentication and if found,
				if(uLS.checkLogin(userName, password)){
					//get the username;
					user = uLS.getUser(userName);
					//supply session object with authenticate user and product list retrieved from the database; 
					session.setAttribute("user", user);
					session.setAttribute("products",uLS.showProducts());
					//redirect session objects to 'productionSelection.jsp'
					response.sendRedirect(request.getContextPath()+"/productSelection.jsp");
				}else{
					//Authentication failure from LoginController; user not in Database; Please correct  credentials or please register prior to login attempt"
					response.sendRedirect(request.getContextPath()+"/error/fail.jsp");
				}
				//catch any SQL or application exception and send error to the assigned jsp.
			}catch(ApplicationException e){
				request.setAttribute("error", "ApplicationException");
				RequestDispatcher rD = request.getRequestDispatcher("login.jsp");
				rD.forward(request, response);
			}
		}
	}
	
	
	
	
	//CHANGE!!!!!!!!
//	//check whether user exists in a database table by supplying from jsp potential-user credentials, userName and password																																																																																																																																																																																																																																																				
//	public boolean checkLogin(String userName, String password){
//		//instantiate a User object
//		User user = new User();
//		//instantiate a UserDAOImpl object
//		UserDAO userDao = new UserDAOImpl();
//		//set user credentials as states of the user object for querying the database with said credentials in an attempt to authenticate the user
//		user.setUserName(userName);
//		user.setPassword(password);
//		//return boolean depending on user user authentication
//		return userDao.checkByName(user);
//	}
	
//	//retrieve userName state of an authenticated user from the database 
//	public User getUser(String userName){
//		//instantiate User and UserDAOImpl object for database query of already existing userName 
//		User user = new User();
//		UserDAO userDao = new UserDAOImpl();
//		//get userName from a table
//		user = userDao.getUser(userName);	
//		return user;
//	}
	
//	//attempt to register a potential-user in case the data does not exist in the database;
//	public boolean register(String userName, String email, String password){
//		//instantiate User and UserDAOImpl object for database query;
//		User user = new User();
//		UserDAO  userDao = new UserDAOImpl();
//		
//		//Assign states to User object;
//		user.setUserName(userName);
//		user.setEmail(email);
//		user.setPassword(password);
//		
//		//Check whether the user exists in the database using the userDao object's checkExisting method which takes the userName;
//		if(userDao.checkExisting(userName)){
//			//return false for an existing userName in database;
//			return false;
//		}else{
//			//else add user to database and return true;
//			userDao.addUser(user);
//			return true;
//		}
//	}
	
//	//Show names of all the products available in the shop
//	public List<Product> showProducts(){
//		
//		//Instantiate an ArrayList of Product objects;
//		List<Product> lp = new ArrayList<>();
//		
//		//Instantiate a new ProductDAOImpl object to use the class' getAllProduct method;
//		ProductDAO pDao = new ProductDAOImpl();
//		
//		//populate lp with returned list of all product names;
//		lp = pDao.getAllProducts();
//		
//		return lp;
//	}

	
	
}
