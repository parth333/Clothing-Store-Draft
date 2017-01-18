package dao;

import java.util.ArrayList;

import dto.Order;

public class RemoveItemDAO {

	public boolean removeItem(ArrayList<Order> lO, String itemToRemove) {

		for(Order o: lO){
			if(o.getName().equals(itemToRemove)){
				lO.remove(o);
				break;
				
			}
		}
		
		return true;
		
	}

}
