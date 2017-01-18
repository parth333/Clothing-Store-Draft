package service;

import dao.UserRegistrationDAO;
import exception.ApplicationException;

public class UserRegistrationService {
	
	UserRegistrationDAO uRDAO = new UserRegistrationDAO();

	public boolean registerUser(String userName, String email, String password) throws ApplicationException {
		return uRDAO.insertNewUser(userName,email,password);
	}

}
