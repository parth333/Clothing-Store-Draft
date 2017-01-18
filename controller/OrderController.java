package controller;

import service.OrderService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Order;
import exception.ApplicationException;

//This is the controller for the servlet that receives data from relative link "/OrderServlet" after the shopper
//uses checkboxes to select the products which she may want to buy on the 'productSelection.jsp';
public class OrderController {

	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		//do back-end check on hidden parameters prior to begining of processing work to potentially save time in case wrong ones are received by the servlet

		String action = request.getParameter("tryOrderingSelectedProducts");

		//check values of the received parameter

		if(action.equalsIgnoreCase("orderSelectedProducts")){
			
			//Receive multiple item names and their corresponding quantity string values to be placed into the cart;
			
			String [] items = request.getParameterValues("item");
			String [] quantity = request.getParameterValues("quantity");
			
			//if no items selected by user, then redirect request to the productSelection.jsp
			if(items == null || items.length == 0){
				response.sendRedirect(request.getContextPath()+"/productSelection.jsp");

			}else{
			
			//create new OrderService object;
			OrderService oS = new OrderService();
			//ProductController pc = new ProductController();
			//create new ArrayList of products/items to be filled with checkboxed items passed from 'result.jsp'
			List<Order> lO = null;
			
			//Retrieve an existing session object, but don't create a new one
			HttpSession session = request.getSession(false);
			
			try{
				
				if(oS.getOrder(items).size() != 0){
					
					//populate the ArrayList with checkboxed/selected products along with their price; 
					lO = oS.getOrder(items);
//					List<Product> lp = new ArrayList<>();
//					lp = pc.showDetail(items);
					
					
					//provide the list of selected products to the session;
					session.setAttribute("order", lO);
					//session.setAttribute("order", lp);
					//send the product-list to 'order.jsp';
					response.sendRedirect(request.getContextPath()+"/order.jsp");
					}else{
						//Order list is empty; check database for empty fields;
						response.sendRedirect(request.getContextPath()+"/error/fail.jsp");
					}

				}
			//send back-end type error to the following jsp in case of 'if' condition failure

				catch(ApplicationException e){
					request.setAttribute("error", "ApplicationException");
					RequestDispatcher rD = request.getRequestDispatcher("result.jsp");
					rD.forward(request, response);
				}
	
		}
		}
		
		
		
	}

}
