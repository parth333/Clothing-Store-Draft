package servlet;

import controller.OrderController;
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

import controller.LoginController;
import controller.ProductController;
import dto.Order;


/**
 * Servlet implementation class OrderServlet
 */
//This servlet receives data from relative link "/OrderServlet" after the shopper
//uses checkboxes to select the products which she may want to buy on the 'productSelection.jsp';
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//do back-end check on hidden parameters prior to begining of processing work to potentially save time in case wrong ones are received by the servlet

		String action = request.getParameter("tryOrderingSelectedProducts");
		
		//check value of the received parameter

		if(action != null && action.equalsIgnoreCase("orderSelectedProducts")){
			new OrderController().processRequest(request, response);
		}
		else{
			//send back-end type error to the following jsp in case of 'if' condition failure

			request.setAttribute("error", "back-end error from OrderServlet");
			RequestDispatcher rD = request.getRequestDispatcher("productSelection.jsp");
			rD.forward(request, response);
		}

		
		
		//CHANGE!!!!!!!!!!!!!!!!
//
//		
//		//Receive multiple item names and their corresponding quantity (1) string values to be placed into the cart;
//		String [] items = request.getParameterValues("item");
//		String [] qty = request.getParameterValues("qty");
//		
//		//create new product controller object;
//		ProductController pc = new ProductController();
//		//create new ArrayList of products/items to be filled with checkboxed items passed from 'result.jsp'
//		List<Order> lo = new ArrayList<>();
//		
//		//populate the ArrayList with checkboxed/selected products along with their price; 
//		lo = pc.getOrder(items, qty);
////		List<Product> lp = new ArrayList<>();
////		lp = pc.showDetail(items);
//		
//		//Retrieve an existing session object, but don't create a new one
//		HttpSession session = request.getSession(false);
//		//provide the list of selected products to the session;
//		session.setAttribute("order", lo);
//		//session.setAttribute("order", lp);
//		//send the product-list to 'order.jsp';
//		response.sendRedirect(request.getContextPath()+"/order.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
