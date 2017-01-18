package service;

import java.util.List;

import dto.Product;
import exception.ApplicationException;
import dao.SearchProductDAO;

public class SearchProductService {
	
	SearchProductDAO sPDAO  = new SearchProductDAO();

	public List<Product> showProductDetails(String[] selections) throws ApplicationException {
		// TODO Auto-generated method stub
		return sPDAO.showProductDetails(selections);
	}

}
