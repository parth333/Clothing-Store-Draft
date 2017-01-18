package dao;

import java.util.List;

import dto.Product;

//interface to be implemented for retrieve 'Product' object instances (database rows) from database
public interface ProductDAO {
	//the 'Product' objects will be retrieved as elements within a list using the 'getAllProduct' method that returns the list
	public List<Product> getAllProducts();
	
	//an individual product can be retrieved using the implementation of 'getProduct' method
	public Product getProduct(String name);
	
}
