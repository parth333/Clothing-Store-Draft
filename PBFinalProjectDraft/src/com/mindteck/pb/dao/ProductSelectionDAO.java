package com.mindteck.pb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mindteck.pb.dto.Clothes;
import com.mindteck.pb.exception.ApplicationException;


public class ProductSelectionDAO {
	


	public ArrayList readItemFromClothesTable() throws ApplicationException {
	
		List<Clothes> clothes = new ArrayList();
		
		try(Connection conn = DBConnection.getConnection();
				PreparedStatement st = conn.prepareStatement("select distinct item from clothes");){
			
			try(ResultSet clothingSelection = st.executeQuery()){
				while(clothingSelection.next()){
					Clothes c = new Clothes();
					c.setItem(clothingSelection.getString("item"));
					clothes.add(c);
					
				}
			}
		}
		catch(SQLException e){
			
			throw new ApplicationException(e);
		
		}
		return (ArrayList) clothes;
		
	}

}
