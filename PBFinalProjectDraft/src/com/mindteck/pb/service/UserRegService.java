package com.mindteck.pb.service;

import com.mindteck.pb.dao.UserRegDAO;
import com.mindteck.pb.dto.Users;
import com.mindteck.pb.exception.ApplicationException;

public class UserRegService {
	
	UserRegDAO urdao = new UserRegDAO();
	
	public boolean registerUser(String userID, String name, String pass) throws ApplicationException {
		return urdao.insertNewUser(userID,name,pass);
	}
	
	

}
