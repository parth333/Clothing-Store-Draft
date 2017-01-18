package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Order;
import exception.ApplicationException;
import service.RemoveItemService;

//Controller class associated with servlet Class to change the initial product quantity that was placed in the cart; 
//This servlet receives requests from the reference URI containing "/RemoveItemFromCart"
public class RemoveItemController {
	
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		//do back-end check on hidden parameters prior to begining of processing work to potentially save time in case wrong ones are received by the servlet

			String action = request.getParameter("tryRemovingItem");;
		
		
		if(action.equalsIgnoreCase("removeItem")){
			
			//get the remove parameter value ('remove') in case the client clicks the remove button to remove object from cart
			//it will be passed as a method parameter to remove cart object 
			String itemToRemove = request.getParameter("itemName");
			
			//get the remove parameter value ('remove') in case the client clicks the remove button to remove object from cart
			//it will be passed as a method parameter to remove cart object 
			//String remove = request.getParameter("remove");
			
			RemoveItemService rIS = new RemoveItemService();

			//get an existing session, but not create a new session in case the session do not exist already
		   HttpSession session = request.getSession(false);
			
			//reference an ArrayList of Order objects by bringing an existing  'order' (list of customer-order) object into this session
			//and cast it to an ArrayList object
			@SuppressWarnings("unchecked")
			ArrayList<Order> lO = (ArrayList<Order>) session.getAttribute("order");
			//after letting the ArrayList reference the 'order' object brought into the session, remove the 'order' object from this session 
			//as it will be replaced by a potentially updated order-list
			session.removeAttribute("order");
			
			try{
					//check if removing item is successful
					if(rIS.removeItem(lO, itemToRemove)){
						
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