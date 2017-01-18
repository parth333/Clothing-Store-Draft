package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import dao.ConnectionManager;

public class testConnection {
	
	
	@Test
	public void test1(){
		Connection conn = ConnectionManager.getConnect();
		System.out.println(conn);
	}
	
	@Test
	public void test2() throws ClassNotFoundException, SQLException{
		Connection conn = ConnectionManager.getConnect();
		String sql = "select * from user";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			System.out.println("name "+rs.getString(2)+" email: "+rs.getString(3));
		}

		ConnectionManager.close(conn, stmt);
		
	}
}
