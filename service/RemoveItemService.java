package service;

import java.util.ArrayList;

import dao.RemoveItemDAO;
import dto.Order;
import exception.ApplicationException;

public class RemoveItemService {

	RemoveItemDAO rIDAO = new RemoveItemDAO();

	public boolean removeItem(ArrayList<Order> lO, String itemToRemove)  throws ApplicationException{
		
		rIDAO.removeItem(lO,itemToRemove);
		
		return true;
	}
	
	
}
