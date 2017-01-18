package servlet;


import controller.SearchProductController;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Product;

/**
 * Servlet implementation class SearchProductServlet
 */
//This servlet receives a request from the shop user to receive details (prices) for products that they want to purchase (chosen or filtered products selected from the dropdown menu of all available products)
//out of all the products available in the shop, as displayed on 'productSelection.jsp'
@WebServlet("/SearchProductServlet")
public class SearchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //The doGet method will receive the customer request and retrieve all data (table columns) regrading their selected products
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("tryGettingProductDetails");
		
		if(action != null && action.equalsIgnoreCase("getProductDetails")){
			new SearchProductController().processRequest(request, response);
		}else{
			request.setAttribute("error", "back-end error from SearchProductServlet");
			RequestDispatcher rD = request.getRequestDispatcher("productSelection.jsp");
			rD.forward(request, response);
		}
		
		
		//CHANGE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!11

		String [] selections = request.getParameterValues("selection");
//		if(selections==null){
//			System.out.println("do't receive any selection");
//		}else{
//			for(String s:selections){
//				System.out.println(s);
//			}
//		}
		
//		//instantiate a ProductController 
//		ProductController pc = new ProductController();
//		//instantiate an ArrayList to be populated with details of selected product instances
//		List<Product> lp = new ArrayList<>();
//		//populate lp with product details
//		lp = pc.showDetail(selections);
//		//get session if one is available, but don't create a new one
//		HttpSession session = request.getSession(false);
//		
//		//supply session with lp and redirect session object to 'result.jsp'
//		session.setAttribute("result", lp);
//		response.sendRedirect(request.getContextPath()+"/result.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
