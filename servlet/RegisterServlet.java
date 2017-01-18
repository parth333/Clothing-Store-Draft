package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.RegistrationController;

import controller.LoginController;
import dto.User;

/**
 * Servlet implementation class RegisterServlet
 */
//This servlet receives requests from 'register.jsp' in order to let a user make an attempt at website
//registration;
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("tryRegistration");
		
		if(action != null && action.equalsIgnoreCase("register")){
			new RegistrationController().processRequest(request,response);
		}
		else{
			request.setAttribute("error", "Back-end error in register.jsp");
			RequestDispatcher rD = request.getRequestDispatcher("register.jsp");
			rD.forward(request, response);
		}
/////////////////////////////////////////////////////////		
//		//get the username, email, and password to be stored in the database;
//		String userName = request.getParameter("username");
//		String email = request.getParameter("email");
//		String password = request.getParameter("password");
		
//		//logincontroller class will be used to persist the user data;
//		LoginController lc = new LoginController();
//		//create a new User object;
//		User user = new User();
//		//attempt to persist the client data passed in at 'register.jsp';
//		user.setEmail(email);
//		user.setUserName(userName);
//		user.setPassword(password);
//		
//		//if the client can be registered, then
//		if(lc.register(userName, email, password)){
//			//redirect the newly registered user to the login page;
//			response.sendRedirect(request.getContextPath()+"/login.jsp");
//		}else{
//			//else send the client to the 'registerError.jsp' page;
//			response.sendRedirect(request.getContextPath()+"/error/registerError.jsp");
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
