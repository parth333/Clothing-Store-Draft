package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserRegistrationService;

import dto.User;
import exception.ApplicationException;

public class RegistrationController {
	
	UserRegistrationService uRS = new UserRegistrationService();

	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("tryRegistration");
		
		if(action.equalsIgnoreCase("register")){
			//get the username, email, and password to be stored in the database;
			String userName = request.getParameter("username");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			try{
				
				boolean newlyRegisteredUser = uRS.registerUser(userName,email,password);

				//logincontroller class will be used to persist the user data;
				//CHANGE!!!!!!!!!!!!1
				//LoginController lc = new LoginController();
				//create a new User object;
				User user = new User();
				//attempt to persist the client data passed in at 'register.jsp';
				//CHANGE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				user.setEmail(email);
				user.setUserName(userName);
				user.setPassword(password);
				
				//if the client can be registered, then
				//CHANGE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
				if(newlyRegisteredUser){
					//redirect the newly registered user to the login page;
					response.sendRedirect(request.getContextPath()+"/login.jsp");
				}else{
					//else send the client to the 'registerError.jsp' page;
					response.sendRedirect(request.getContextPath()+"/error/registerError.jsp");
				}
				
			}catch(ApplicationException e){
				request.setAttribute("error", "*changethisline* User exists in DB or other error; Primary key error from RegistrationController or other error");
				RequestDispatcher rD = request.getRequestDispatcher("register.jsp");
				rD.forward(request, response);
			}
		}

	}

}
