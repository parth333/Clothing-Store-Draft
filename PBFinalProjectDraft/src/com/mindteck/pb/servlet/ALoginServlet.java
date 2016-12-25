package com.mindteck.pb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindteck.pb.controller.LoginController;
import com.mindteck.pb.controller.ProductSelectionController;

//@WebServlet("/login")
public class ALoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ALoginServlet(){
		super();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String action = req.getParameter("tryLogin");
		
		if(action != null && action.equalsIgnoreCase("login")){
			new LoginController().processRequest(req, res);
		//	new ProductSelectionController().processDB(req,res);

		}
		else{
			req.setAttribute("error", "back-end error from ALoginServlet");
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, res);
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
