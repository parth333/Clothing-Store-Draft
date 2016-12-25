package com.mindteck.pb.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindteck.pb.dto.Clothes;
import com.mindteck.pb.exception.ApplicationException;
import com.mindteck.pb.service.ProductSelectionService;


public class ProductSelectionController {
	
	ProductSelectionService pSS = new ProductSelectionService();
	
	public void processDB(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		List<Clothes> clothingSelection = null;
		
		try{
			
			clothingSelection = pSS.readDB();
			
			if(clothingSelection != null && clothingSelection.get(0).getItem() != ""){
				
				req.setAttribute("items", clothingSelection);
				RequestDispatcher rd = req.getRequestDispatcher("productSelection.jsp");
				rd.forward(req,res);				
				
			}
			else{
				
				req.setAttribute("error", "ProductSelectionController check that 'item' field in DB is not null or blank");
				RequestDispatcher rd = req.getRequestDispatcher("productSelection.jsp");
				rd.forward(req, res);
				
			}
			
			
		}
		catch(ApplicationException e){
			req.setAttribute("error", "ProductSelectionController ApplicationException");
			RequestDispatcher rd = req.getRequestDispatcher("productSelection.jsp");
			rd.forward(req, res);
		}
		
	}


}
