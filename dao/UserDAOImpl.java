package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import dto.User;

//implementation of 'UserDAO' interface that is used to define methods
public class UserDAOImpl implements UserDAO {
	
	//read table for querying User data;
		@Override
	public User getUser(String name) {
			
			//assign 'conn' to the 'Connection' object;

		Connection con = ConnectionManager.getConnect();
		
		//read-type SQL query to retrieve user related data given a constraint for user  name

		String sql ="select * from User u where u.name=?";
		try{
			//pass SQL statment to the prepareStatement method for querying database;

			PreparedStatement stmt = con.prepareStatement(sql);
			//pass SQL statment to the prepareStatement method for querying database based on constraint position '1' given the value of 'name' parameter passed into method;

			stmt.setString(1,name);
			//execute SQL query and assign any read data to memory location referenced by 'rs';

			ResultSet rs = stmt.executeQuery();
			
			//assign element of 'ResultSet' to new instance of 'User' after instantiating object of 'User'

			User user = new User();
			while(rs.next()){
				
				//Set the name of 'User' to string at third position (index == 2)

				user.setUserName(rs.getString(2));
				
				//Set the 'User' email to third index;

				user.setEmail(rs.getString(3));
				
				//Set the 'User' password to fourth index;

				user.setPassword(rs.getString(4));
			}
			//Regardless of other code execution within method, ensure execution of 'close' method;

			ConnectionManager.close(con, stmt,rs);
			return user;
		}
		//catch exception
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

		//definition of getAllUser method;
	@Override
	public List<User> getAllUser() {

		//assign 'conn' to the 'Connection' object;

		Connection conn = ConnectionManager.getConnect();
		
		//assign connection parameters;

		PreparedStatement stmt=null;
		
		//use 'rs' variable that may reference a ResultSet object

		ResultSet rs =null;
		//read-type SQL query to retrieve product related data

		String sql = "select *from User";
		try{
			//pass SQL statement to the prepareStatement method for querying database;

			stmt = conn.prepareStatement(sql);
			//execute SQL query and assign any read data to memory location referenced by 'rs';

			rs = stmt.executeQuery();
			//Instantiate ArrayList of 'User' instances;

			List<User> users = new ArrayList<>();
			while(rs.next()){
				//assign element of 'ResultSet' to new instance of 'User'

				User user = new User();
				//Set the name of 'User' to string at third position (index == 2)

				user.setUserName(rs.getString(2));
				//Set the email of 'User' to string at third index

				user.setEmail(rs.getString(3));
				//Set the password  of 'User' to string at fourth index
				user.setPassword(rs.getString(4));
				//add object to list
				users.add(user);
			}
			return users;
			//catch exception
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			//close connection related objects
			ConnectionManager.close(conn, stmt,rs);
		}
		
	}

	//insert user into table
	@Override
	public void addUser(User user) {
		//assign 'con' to the 'Connection' object;
		Connection con = ConnectionManager.getConnect();
		//assign connection parameters;

		PreparedStatement stmt= null;
		//insert user into table by providing name, email.password
		String sql = "insert into User(name, email, password) values(?,?,?)";
		try{
			//pass SQL statment to the prepareStatement method for accessing database;

			stmt= con.prepareStatement(sql);
			
			//set 'stmt' parameter to insert 'User' data into table by using 'get' methods on instantiated 'User' object;

			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPassword());
			
			//execute the sql query
			stmt.executeUpdate();
			
			//catch exception
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			
			//close connection related objects
			ConnectionManager.close(con, stmt);
		}
		
	}

	@Override
	public boolean delUser(String email) {
		//assign connection parameters;

		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			//assign 'conn' to the 'Connection' object;

			conn = ConnectionManager.getConnect();
			String sql = "delete from User where email=?";
		
			//pass SQL statment to the prepareStatement method for accessing database;

			stmt = conn.prepareStatement(sql);
			
			//delete row where email is the same as the one passed into the method
			stmt.setString(1, email);
			//return 'true' upon successful query execution
			return stmt.executeUpdate()==0;
			//catch exception
		}catch(Exception e){
			
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			//close connection related objects
			ConnectionManager.close(conn, stmt);
		}
	}

	@Override
	public boolean updateUser(User user) {
		//assign connection parameters;

		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			//assign 'conn' to the 'Connection' object;

			conn = ConnectionManager.getConnect();
			//update-type SQL query to change user (row) related column value

			String sql = "update user set name=?, email=?, password=?";
			//pass SQL statment to the prepareStatement method for querying database;

			stmt = conn.prepareStatement(sql);
			
			//update table row with user related fields passed into table from method
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getEmail());
			stmt.setString(3,user.getPassword());
			
			//return true upon successful query execution;
			return stmt.executeUpdate()==0?false:true;
			//catch any exceptions
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}finally{
			//obligatorily close the connection related objects;
			ConnectionManager.close(conn, stmt);
		}
			
	}

	@Override
	public boolean checkByName(User user) {
		//assign connection parameters;

		Connection conn =null;
		PreparedStatement stmt =null;
		//use 'rs' variable that may reference a ResultSet object

		ResultSet rs = null;
		try{
			conn = ConnectionManager.getConnect();
			//read-type SQL query to retrieve user related data with name and password constraint

			String sql ="select * from User where name=? and password=?";
			//pass SQL statement to the prepareStatement method for querying database;

			stmt = conn.prepareStatement(sql);
			
			//retain queried result fields of a user object within instantiated object
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getPassword());
			//execute SQL query and assign any read data to memory location referenced by 'rs';

			//store results of executed query into the ResultSet;
			rs = stmt.executeQuery();
			//Return true if rs contains a value;
			if(rs.next()){
					return true;
			}
			return false;
			//catch any exceptions;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			//closer database connection related objects;
			ConnectionManager.close(conn, stmt,rs);
		}
	}

	@Override
	public boolean checkExisting(String name) {
		//assign connection parameters;

		Connection conn =null;
		PreparedStatement stmt =null;
		//use 'rs' variable that may reference a ResultSet object

		ResultSet rs = null;
		try{
			//assign 'conn' to the 'Connection' object;

			conn = ConnectionManager.getConnect();
			//read-type SQL query to retrieve user related data with name constraint

			String sql ="select * from User where name=? ";
			//pass SQL statement to the prepareStatement method for querying database;

			//prepare connection statement for query execution by passing in the SQL query string 
			stmt = conn.prepareStatement(sql);
			
			//prepare parameter of method to be passed into SQL string for query execution
			stmt.setString(1, name);
			//store result of executed query in the 'ResultSet'
			rs = stmt.executeQuery();
			//Return true if the ResultSet contains a value
			if(rs.next()){
				return true;
			}else{
				return false;
			}
			
			//catch any exceptions
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
			
		}finally{
			//close connection objects
			ConnectionManager.close(conn, stmt,rs);
		}
	}

}
