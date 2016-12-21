package com.mindteck.pb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mindteck.pb.dto.User;
import com.mindteck.pb.exception.ApplicationException;

public class UserLoginDAO {

	public User find(String userId) throws ApplicationException {
		User user = null;

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement statement = connection
						.prepareStatement("SELECT user_id FROM user WHERE user_id=?");) {
			statement.setString(1, userId);
			//statement.setString(2, pass);

			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					user = new User();
					user.setUserId(resultSet.getString("user_id"));
					
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
