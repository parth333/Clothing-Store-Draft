package service;

import java.io.IOException;
import java.util.ArrayList;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Order;

/**
 * Servlet implementation class UpdateOrder
 */
//Servlet Class to change the initial product quantity that was placed in the cart; 
//This servlet receives requests from the reference URI containing "/UpdateOrder"
@WebServlet("/UpdateOrder")
public class UpdateOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public UpdateOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //Servlet doGet method mapped to receive requests and provide responses
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get the tempItem hidden parameter for which the value is the item name for which the user has clicked update button on the web page
		String tempItem = request.getParameter("tempItem");
		//get the tempQty parameter for which the value is the item quantity for which the user has clicked update button on the web page 
		String tempQty = request.getParameter("tempQty");
		//get the remove parameter value ('remove') in case the client clicks the remove button to remove object from cart
		//it will be passed as a method parameter to remove cart object 
		String remove = request.getParameter("remove");
		//get the removeItem hidden parameter value (the item name) in case the client clicks the remove button to remove objject from cart;
		String removeItem = request.getParameter("removeItem");
		
		//get an existing session, but not create a new session in case the session do not exist already
		HttpSession session = request.getSession(false);
		@SuppressWarnings("unchecked")
		
		//reference an ArrayList of Order objects by bringing an existing  'order' (list of customer-order) object into this session
		//and cast it to an ArrayList object
		ArrayList<Order> lo = (ArrayList<Order>) session.getAttribute("order");
		//after letting the ArrayList reference the 'order' object brought into the session, remove the 'order' object from this session 
		//as it will be replaced by a potentially updated order-list
		session.removeAttribute("order");
//		Iterator<Order> it = lo.iterator();
//		while(it.hasNext()){
//			System.out.println(it.next().getName()+it.next().getQty());
//			if(it.next().getName().equals(tempItem) && !it.next().getQty().equals(tempQty)){
//				it.next().setQty(tempQty);
//				System.out.println(it.next().getName()+it.next().getQty());
//				break;
//			}
//		}
		
		//for any order in the current list of orders for which the client clicked the update button, retrieve
		//the current quantity and item name and set quantity to a new quantity as changed by the user in the
		//webpage textbox
//		for(Order o: lo){
//			if(o.getName().equals(tempItem)&& !o.getQty().equals(tempQty)){
//				o.setQty(tempQty);
//				break;
//			}
//		}
		//check if jsp is correctly assigned correct value ('remove') for the 'remove' variable
		if("remove".equals(remove)){
			//for the retrieved list of orders
			for(Order o: lo){
				//if an order's name is the same as the one for which the client clicked the remove
				//remove button, then remove the item from the list
				if(o.getName().equals(removeItem)){
					lo.remove(o);
					break;
				}
			}
		}
		
		
		//assign the name 'order' to the list of orders that is updated in this session.
		session.setAttribute("order", lo);
		
		//redirect the new list of orders to order.jsp
		response.sendRedirect(request.getContextPath()+"/order.jsp");
		
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Access the doGet method from the doPost method
		doGet(request, response);
	}

}
