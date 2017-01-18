package service;

import dao.UserLoginDAO;

import java.util.List;

import dto.Product;
import dto.User;
import exception.ApplicationException;

public class UserLoginService {
	
	UserLoginDAO uLDAO  = new UserLoginDAO();

	public boolean checkLogin(String userName, String password) throws ApplicationException{
		// TODO Auto-generated method stub
		return uLDAO.checkLogin(userName, password);
	}

	public User getUser(String userName) throws ApplicationException {
		// TODO Auto-generated method stub
		return uLDAO.getUser(userName);
	}


	public List<Product> showProducts() throws ApplicationException {
		// TODO Auto-generated method stub
		return uLDAO.showProducts();
	}





}
