package com.mindteck.pb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mindteck.pb.dto.Users;
import com.mindteck.pb.exception.ApplicationException;

public class UserLoginDAO {

	public Users find(String userId) throws ApplicationException {
		Users user = null;

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement statement = connection
						.prepareStatement("SELECT user_email FROM users WHERE user_email=?");) {
			statement.setString(1, userId);
			//statement.setString(2, pass);

			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					user = new Users();
					user.setUserId(resultSet.getString("user_email"));
					
					System.out.println("user found in DB");
					//user.setPass(resultSet.getString("pass"));
				}
			}
		} catch (SQLException e) {

			throw new ApplicationException(e);
		}

		return user;
	}

}
