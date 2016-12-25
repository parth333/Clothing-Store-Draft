package com.mindteck.pb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindteck.pb.dto.Users;
import com.mindteck.pb.exception.ApplicationException;
import com.mindteck.pb.service.UserLoginService;
import com.mindteck.pb.service.UserRegService;

public class LoginController {
	
	UserLoginService us = new UserLoginService();
	
	public void processRequest(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		String action = req.getParameter("tryLogin");
		
		if(action.equalsIgnoreCase("login")){
			
			String userId = req.getParameter("user_email");
			//String pass = req.getParameter("pass");
			
			Users userObj = null;
			
			try{
				userObj = us.authenticateUser(userId);
				
				if(userObj != null){
					
					req.setAttribute("user", userObj);
					RequestDispatcher rd = req.getRequestDispatcher("productionSelection.jsp");
					rd.forward(req, res);
					
					/*
					 * 
					 */
					//new ProductSelectionController().processDB(req,res);


				}
				else{
					req.setAttribute("error", "LoginController; user not in DB; Please correct your credentials or please register prior to login attempt");
					RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
					rd.forward(req,res);
				}
				
			}
			catch(ApplicationException e){
				req.setAttribute("error", "ApplicationException");
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				rd.forward(req, res);
			}
			
		}
	}


}
