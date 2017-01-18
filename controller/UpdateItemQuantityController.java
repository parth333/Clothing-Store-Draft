package controller;

import service.UpdateItemQuantityService;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Order;
import exception.ApplicationException;

//Servlet Class associated with this controller is used to change the initial product quantity that was placed in the cart; 
//This servlet receives requests from the reference URI containing "/UpdateItemQuantity" within order.jsp
public class UpdateItemQuantityController {
	
	//create a new service layer object
	UpdateItemQuantityService uIQS = new UpdateItemQuantityService();

	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//get an existing session, but not create a new session in case the session do not exist already
		HttpSession session = request.getSession(false);
		
		//do back-end check on hidden parameters prior to begining of processing work to potentially save time in case wrong ones are received by the servlet

		String action = request.getParameter("tryUpdatingItemQuantity");
		
		//check value of the received parameter
		
		if(action.equalsIgnoreCase("updateItemQuantity")){
			//Receive multiple item names and their corresponding quantity string values, quantities to be replaced into the cart;

			String itemName = request.getParameter("itemName");
			String itemQuantity = request.getParameter("itemQuantity");
			
			
			
			//reference an ArrayList of Order objects by bringing an existing  'order' (list of customer-order) object into this session
			//and cast it to an ArrayList object
			@SuppressWarnings("unchecked")
			ArrayList<Order> lO = (ArrayList<Order>) session.getAttribute("order");
			//after letting the ArrayList reference the 'order' object brought into the session, remove the 'order' object from this session 
			//as it will be replaced by a potentially updated order-list
			session.removeAttribute("order");
			
			try{
				if(uIQS.updateItemQuantity(lO,itemName,itemQuantity)){
					
					//assign the name 'order' to the list of orders that is updated in this session.
					session.setAttribute("order", lO);
					
					//redirect the new list of orders to order.jsp
					response.sendRedirect(request.getContextPath()+"/order.jsp");
					
				}else{
					//method did not reach endpoint to return 'true'
					response.sendRedirect(request.getContextPath()+"/error/fail.jsp");
				}
			}catch(ApplicationException e){
				//send back-end type error to the following jsp in case of 'if' condition failure

				request.setAttribute("error", "ApplicationException");
				RequestDispatcher rD = request.getRequestDispatcher("order.jsp");
				rD.forward(request, response);
			}
		}
	}

}

/*
if{

try{
	if(){
		
	}else{
		
	}
}catch{
	
}
}*/