package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dao.UserDAOImpl;
import dto.User;

public class testUserDao {
	
	@Test
	public void test1(){
		UserDAOImpl udao = new UserDAOImpl();
		List<User> lu = new ArrayList<>();
		lu = udao.getAllUser();
		for(User u: lu){
			System.out.print(u.getUserName()+"---");
			System.out.print(u.getPassword()+"---");
			System.out.println(u.getEmail());
		}
		
	}
	
	@Test
	public void test2(){
		UserDAOImpl udao = new UserDAOImpl();
		User u = new User();
		u.setUserName("root");
		u.setPassword("root");
		System.out.println(udao.checkByName(u));
	}
	
	@Test
	public void test3(){
		UserDAOImpl udao = new UserDAOImpl();
		User u = new User();
		u = udao.getUser("root@gmail.com");
		System.out.println(u.getUserName()+" "+u.getPassword());

	}
	
	@Test
	public void test4(){
		UserDAOImpl udao = new UserDAOImpl();
		User u = new User();
		u.setEmail("root@gmail.com");
		u.setPassword("root");
		u.setUserName("root");
		System.out.println(udao.updateUser(u));
	}
}
