package com.mindteck.pb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindteck.pb.controller.RegistrationController;

//@WebServlet("/reg")
public class ARegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ARegistrationServlet(){
		super();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		String action = req.getParameter("tryReg");
		
		if(action != null && action.equalsIgnoreCase("register")){
			new RegistrationController().processRequest(req,res);
		}
		else{
			req.setAttribute("error", "registration failure");
			RequestDispatcher rd = req.getRequestDispatcher("registration.jsp");
			rd.forward(req, res);
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}
	
}
