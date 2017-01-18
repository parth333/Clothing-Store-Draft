package dao;

import java.util.ArrayList;
import java.util.List;

import dto.Order;
import dto.Product;

public class OrderDAO {

	//this method returns the list of products-order which has product-details and quantity ordered by the customer; 
		//the method accepts String arrays of product names and their associated quantities;
		public List<Order> getOrder(String [] name){
			//instantiate ProductDAO object to use its methods;
			ProductDAO pDao = new ProductDAOImpl();
			//instantiate an Order object ArrayList to be populated with order data
			List<Order> lO = new ArrayList<>();
			
			
//			for(int i=0;i<name.length;i++){
//				Product p = new Product();
//				Order o = new Order();
//				p = pDao.getProduct(name[i]);
//				o.setItem(p);
//				o.setQty(num[i]);
//				lo.add(o);
//				
//			}
			
//			
			//for all product names in input-array parameter
			for(int i=0;i<name.length;i++){
				
				//instantiate a product object whose states will be assigned values based on database table rows
				Product p = new Product();
				//instantiate an Order object which has an additional product-quantity field in addition to all states of the Product object
				Order o = new Order();
				//get all product details and assign states to instantiated Product object using the pDao getProduct method
				p = pDao.getProduct(name[i]);
				//set Order states to values of Product states
				o.setName(p.getName());
				o.setPrice(p.getPrice());
				//set Order quantity state to input-parameter number
				o.setQuantity("1");
				//add Order object to list
				lO.add(o);
			}
			
			return lO;
		}

}
