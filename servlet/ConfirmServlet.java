package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ConfirmController;

/**
 * Servlet implementation class ConfirmServlet
 */
//This servlet accepts incoming data from relative URL "/ConfirmServlet";
//It accepts the total order value for a cart and passes it onto order confirmation page;
@WebServlet("/ConfirmServlet")
public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Check whether order.jsp has hidden parameters of name as following
		String action = request.getParameter("tryCheckingOut");
		
		//check whether value of the order.jsp hidden parameter is the following and continue to other layers to carry out task assigned to this servlet
		
		if(action != null && action.equalsIgnoreCase("checkout")){
			new ConfirmController().processRequest(request, response);
		}
		else{
			//send back-end type error to the following jsp in case of 'if' condition failure
			request.setAttribute("error", "back-end error from ConfirmServlet");
			RequestDispatcher rD = request.getRequestDispatcher("order.jsp");
			rD.forward(request, response);
		}		
		
		//CHANGE!!!!!!!!!!!!!!!!!!
		
//		//incoming total order value to be redirected to the order confirmation page;
//		String total = request.getParameter("total");
//		//get existing session object, but don't create one if it does not exist;
//		HttpSession session = request.getSession(false);
//		//assign 'total' value passed in by the request object  to the session object named "total";
//		session.setAttribute("total", total);
//		//send the total value to 'confirm.jsp';
//		response.sendRedirect(request.getContextPath()+"/confirm.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//access the doGet method from the doPost;
		doGet(request, response);
	}

}
