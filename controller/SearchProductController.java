package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Product;
import exception.ApplicationException;
import service.SearchProductService;

public class SearchProductController {
	
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

	
		String action = request.getParameter("tryGettingProductDetails");

		if(action.equalsIgnoreCase("getProductDetails")){
			
			String [] selections = request.getParameterValues("selection");
			
			//instantiate a ProductController object
			SearchProductService sPS = new SearchProductService();
			//ProductController pc = new ProductController();
			//instantiate an ArrayList to be populated with details of selected product instances
			List<Product> lP = null;
			
			//get session if one is available, but don't create a new one
			HttpSession session = request.getSession(false);

			try{
				if(sPS.showProductDetails(selections).size() != 0){
					
					//populate lp with product details
					lP = sPS.showProductDetails(selections);
					
					//supply session with lp and redirect session object to 'result.jsp'
					session.setAttribute("result", lP);
					response.sendRedirect(request.getContextPath()+"/result.jsp");
			}else{
				//no products found in database
				response.sendRedirect(request.getContextPath()+"/error/fail.jsp");
			}
			}catch(ApplicationException e){
				request.setAttribute("error", "ApplicationException");
				RequestDispatcher rD = request.getRequestDispatcher("productSelection.jsp");
				rD.forward(request, response);
			}
			
		}
		
			
	}

}
