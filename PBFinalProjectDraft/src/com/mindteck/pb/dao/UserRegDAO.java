package com.mindteck.pb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mindteck.pb.exception.ApplicationException;

public class UserRegDAO {
	
	public boolean insertNewUser(String userID, String name, String pass) throws ApplicationException {
		//User user = null;

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO user values (?,?,?)");){
			statement.setString(1, userID);
			statement.setString(2, name);
			statement.setString(3, pass);
			
			statement.execute();
			
			System.out.println("Registered Successfully!");
			
		} catch (SQLException e) {

			throw new ApplicationException(e);
			
		}

		return true;
	}

}
