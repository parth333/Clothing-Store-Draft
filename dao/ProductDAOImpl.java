package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import 'dto.Product' class;
import dto.Product;

//this class implements the 'ProductDAO' interface and must define all of its methods;
public class ProductDAOImpl implements ProductDAO {

	//assign connection parameters;
	private Connection conn =null;
	private PreparedStatement stmt =null;
	//use 'rs' variable that may reference a ResultSet object
	private ResultSet rs =null;

	//definition of getAllProduct method;
	@Override
	public List<Product> getAllProducts() {
		try {
			
			//assign 'conn' to the 'Connection' object;
			conn = ConnectionManager.getConnect();
			//read-type SQL query to retrieve product related data
			String sql = "select * from product";
			//pass SQL statement to the prepareStatement method for querying database;
			stmt = conn.prepareStatement(sql);
			//execute SQL query and assign any read data to memory location referenced by 'rs';
			rs = stmt.executeQuery();
			//Instantiate ArrayList of 'Product' instances;
			List<Product> list = new ArrayList<>();
			//if the query returns any data
			while(rs.next()){
				//assign element of 'ResultSet' to new instance of 'Product'
				Product p = new Product();
				//Set the name of 'Product' to string at third position (index == 2)
				p.setName(rs.getString(2));
				//Set the 'Product' price to third index;
				p.setPrice(rs.getString(3));
				//add product to list;
				list.add(p);
			}
			return list;
			//catch SQLException;
		} catch (SQLException e) {
			e.printStackTrace();
			//throw RuntimeException;
			throw new RuntimeException(e);
		}finally{
			//Regardless of other code execution within method, ensure execution of 'close' method;
			ConnectionManager.close(conn, stmt,rs);
		}
	}

	//return 'Product' instance by defining 'getProduct' method of the interface
	@Override
	public Product getProduct(String name) {
		try{
			//assign 'conn' to the 'Connection' object;
			conn = ConnectionManager.getConnect();
			
			//read-type SQL query to retrieve product related data given a constraint for product name
			String sql = "select * from product where name=?";
		
			//pass SQL statement to the prepareStatement method for querying database;
			stmt = conn.prepareStatement(sql);
			
			//pass SQL statement to the prepareStatement method for querying database based on constraint position '1' given the value of 'name' parameter passed into method;
			stmt.setString(1, name);
			
			//execute SQL query and assign any read data to memory location referenced by 'rs';

			rs = stmt.executeQuery();

			//if the query returns any data

			if(rs.next()){
				//assign element of 'ResultSet' to new instance of 'Product' after instantiating object of 'Product'

				Product p = new Product();
				//Set the name of 'Product' to string at third position (index == 2)

				p.setName(rs.getString(2));
				
				//Set the 'Product' price to third index;

				p.setPrice(rs.getString(3));
				return p;
			}else{
				return null;
			}
			//catch SQLException;

		}catch(SQLException e){
			e.printStackTrace();
			//throw RuntimeException;

			throw new RuntimeException(e);
			
		}finally{
			//Regardless of other code execution within method, ensure execution of 'close' method;

			ConnectionManager.close(conn, stmt, rs);
		}


	}

}
