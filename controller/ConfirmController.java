package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ConfirmService;

//Controller layer for ConfirmServlet that accepts the total order value for a cart and passes it onto order confirmation page;

public class ConfirmController {
	

	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Check whether order.jsp has hidden parameters of name as following
		String action = request.getParameter("tryCheckingOut");
		
		//check whether value of the order.jsp hidden parameter is the following and continue to other layers to carry out task assigned to this servlet
		if(action.equalsIgnoreCase("checkout")){
			
			//get the total order price value from order.jsp
			String total = request.getParameter("total");
			
			//If there exists a session object then reference it, but don't create a new session object
			HttpSession session = request.getSession(false);

			try{
				
				//assign 'total' value passed in by the request object  to the session object named "total";
				session.setAttribute("total", total);
				
				//send the total value to 'confirm.jsp';
				response.sendRedirect(request.getContextPath()+"/confirm.jsp");

				//catch any SQL or application exception and send error to the assigned jsp.
			}catch(Exception e){
				
				request.setAttribute("error", "Exception");
				RequestDispatcher rD = request.getRequestDispatcher("order.jsp");
				rD.forward(request, response);
				
			}

			
		}


	}

}
