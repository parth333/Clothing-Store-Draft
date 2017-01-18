package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.LoginController;
import dto.User;


/**
 * Servlet implementation class LoginServlet
 */

//this servlet receives the username and password from 'login.jsp' in order to authenticate
//a client attempting to login to the store to make purchases
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	//constructor that calls the constructor of the superclass
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//do back-end check on hidden parameters prior to begining of processing work to potentially save time in case wrong ones are received by the servlet

		String action = request.getParameter("tryLogin");
		
		//check value of the received parameter

		if(action != null && action.equalsIgnoreCase("login")){
			//if true, begin rest of the login process within the controller layer
			new LoginController().processRequest(request, response);
		}
		else{
			//send back-end type error to the following jsp in case of 'if' condition failure

			request.setAttribute("error", "back-end error from ALoginServlet");
			RequestDispatcher rD = request.getRequestDispatcher("login.jsp");
			rD.forward(request, response);
		}

//		//CHANGE!!!!!!!!!!!!!!!!
//		//receive the username and password
//		String userName = request.getParameter("username");
//		String password = request.getParameter("password");
//		
//		//create a new LoginController object in order to make any changes to the login
//		//parameters before passing it to the database layer for authentication
//		LoginController lc = new LoginController();
//		
//		//Create a new User object
//		User user = new User();
//		//userDao = new UserDAOImpl();
//		
//		//If there exists a session object then reference it, otherwise create a new session object
//		HttpSession session = request.getSession(true);
		
//		//Check the username and password for the purpose of user authentication and if found,
//		if(lc.checkLogin(userName, password)){
//			//get the username;
//			user = lc.getUser(userName);
//			//supply session object with authenticate user and product list retrieved from the database; 
//			session.setAttribute("user", user);
//			session.setAttribute("products",lc.showProducts());
//			//redirect session objects to 'productionSelection.jsp'
//			response.sendRedirect(request.getContextPath()+"/productionSelection.jsp");
//		}else{
//			//else user is not authenticated, then send response obect to 'fail.jsp'
//			response.sendRedirect(request.getContextPath()+"/error/fail.jsp");
//		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
