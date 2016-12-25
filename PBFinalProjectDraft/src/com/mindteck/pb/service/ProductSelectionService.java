package com.mindteck.pb.service;

import java.util.ArrayList;

import com.mindteck.pb.dao.ProductSelectionDAO;
import com.mindteck.pb.exception.ApplicationException;

public class ProductSelectionService {
	
	ProductSelectionDAO pSDAO = new ProductSelectionDAO();
	
	public ArrayList readDB() throws ApplicationException {
		return pSDAO.readItemFromClothesTable() ;
	}

}
