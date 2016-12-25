package com.mindteck.pb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindteck.pb.controller.ProductSelectionController;

public class AProductSelectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public AProductSelectionServlet(){
		super();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// no use of req and res
		
		new ProductSelectionController().processDB(req,res);

		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
