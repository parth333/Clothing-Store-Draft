package com.mindteck.pb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindteck.pb.dto.User;
import com.mindteck.pb.exception.ApplicationException;
import com.mindteck.pb.service.UserRegService;

public class RegistrationController{
	
	UserRegService us = new UserRegService();
	
	public void processRequest(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		String action = req.getParameter("tryReg");
		
		if (action.equalsIgnoreCase("register")){
			
			String userID = req.getParameter("user_id");
			String name = req.getParameter("name");
			String pass = req.getParameter("pass");
			
			//User userObj = null;
			
			try{
				boolean newDBUserID = us.registerUser(userID,name,pass);
				
				//if new user added to user DB, then newDBUserID == true
				if(newDBUserID){
					
					req.setAttribute("newRegistration", "Registration complete!");
					RequestDispatcher rd = req.getRequestDispatcher("registration.jsp");
					rd.forward(req, res);
				}
				else{
					req.setAttribute("error", "user-email already exists in in DB; login or register with a unique email");
					RequestDispatcher rd = req.getRequestDispatcher("registration.jsp");
					rd.forward(req, res);
				}
			}
			catch(ApplicationException e){
				
				req.setAttribute("error", "*changethisline* User exists in DB or other error; Primary key error from RegistrationController or other error");
				RequestDispatcher rd = req.getRequestDispatcher("registration.jsp");
				rd.forward(req, res);
			}
			
		}
		
	}

}
