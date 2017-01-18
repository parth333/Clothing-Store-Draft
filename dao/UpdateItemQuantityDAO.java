package dao;

import java.util.List;

import dto.Order;
import exception.ApplicationException;

public class UpdateItemQuantityDAO {
	
public boolean updateItemQuantity(List<Order> lO, String itemName, String itemQuantity) throws ApplicationException{
		
		for(Order o: lO){
			if(o.getName().equals(itemName) && !o.getQuantity().equals(itemQuantity)){
				o.setQuantity(itemQuantity);
				break;
			}
		}
		
		return true;
	}

}
