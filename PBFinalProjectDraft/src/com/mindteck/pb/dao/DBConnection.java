package com.mindteck.pb.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnection {
	

	private static DataSource dataSource;

	static {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/ecommerce");
		} catch (NamingException e) {

		}
	}

	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	public static void closeConnection(Connection con) {

		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
