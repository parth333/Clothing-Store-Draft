package dao;

import java.util.ArrayList;
import java.util.List;

import dto.Product;

public class SearchProductDAO {


	//show all details (columns) of a product for products selected by the customer;
		public List<Product> showProductDetails(String [] selection){
			
			//instantiate a ProductDAOImpl object to use its method;
			ProductDAO pDao = new ProductDAOImpl();
			//instantiate a list of Product objects;
			List<Product> lp = new ArrayList<>();
			//Populate lp with retrieved states of all selected products within the table
			for(String s: selection){
				//instantiate a new Product object whose states will be assigned values from the table columns for product names within String s
				Product p = new Product();
				//set p to the product object returned from the database by the getProduct method 
				p = pDao.getProduct(s);
				//add p to lp and return it
				lp.add(p);
			}
			
			return lp;
		}
}
