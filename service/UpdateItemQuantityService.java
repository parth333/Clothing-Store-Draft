package service;

import java.util.List;

import dao.UpdateItemQuantityDAO;
import exception.ApplicationException;
import dto.Order;

public class UpdateItemQuantityService {
	
	UpdateItemQuantityDAO uIQDAO = new UpdateItemQuantityDAO();

	public boolean updateItemQuantity(List<Order> lO, String itemName, String itemQuantity) throws ApplicationException{
		
		uIQDAO.updateItemQuantity(lO, itemName, itemQuantity);
		
		return true;
	}

}
