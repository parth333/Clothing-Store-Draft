package com.mindteck.pb.service;

import com.mindteck.pb.dao.UserLoginDAO;
import com.mindteck.pb.dao.UserRegDAO;
import com.mindteck.pb.dto.User;
import com.mindteck.pb.exception.ApplicationException;

public class UserLoginService {
	
	UserLoginDAO uldao = new UserLoginDAO();
	
	public User authenticateUser(String userId) throws ApplicationException {
		return uldao.find(userId);
		
	}
	

}
