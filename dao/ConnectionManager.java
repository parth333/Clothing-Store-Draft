package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//establish connection to the database using this class
public class ConnectionManager {
	//assign database login parameters
	private  static String url="jdbc:mysql://localhost:3306/final_project?autoReconnect=true&useSSL=false";
	private static  String user="root";
	private static String password = "root";

//attempt to retrieve "Driver" class from the 'mysql-connector-java-5.1.6.jar' file in the 'Maven Dependencies' folder
static{
	try{
		Class.forName("com.mysql.jdbc.Driver");
	}catch(Exception e){
		e.printStackTrace();
	}
}

//Attempt database connection return returning a 'Connection' object
	public static Connection getConnect(){
		try{
			Connection conn = DriverManager.getConnection(url,user, password);
			return conn;
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		

	}
	
	//static method to close connection
	public static void close(Connection conn, PreparedStatement stmt){
		//try closing the 'PreparedStatement' object if it is not null
		if(stmt!=null){
			try{
				stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		
		//try closing the 'PreparedStatement' object if it is not null
		if(conn!=null){
			try{
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		
	}
	
	//overloaded close method with an additional 'ResultSet' parameter
	public static void close(Connection conn, PreparedStatement stmt,ResultSet rs){
		
		//try closing the 'ResultSet' object if it is not null
		if(rs!=null){
			try{
				rs.close();
			}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		
		//try closing the 'PreparedStatement' object if it is not null
		if(stmt!=null){
			try{
				stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		
		//try closing the 'Connection' object if it is not null
		if(conn!=null){
			try{
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		
	}
	
	
}
