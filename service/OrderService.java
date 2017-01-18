package service;

import dao.OrderDAO;
import java.util.List;

import dto.Order;
import exception.ApplicationException;

public class OrderService {

	OrderDAO oDAO = new OrderDAO();
	
	public List<Order> getOrder(String[] items) throws ApplicationException {
		// TODO Auto-generated method stub
		return oDAO.getOrder(items);
	}

}
