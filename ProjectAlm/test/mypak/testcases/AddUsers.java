package mypak.testcases;

import static org.junit.Assert.*;


import mypak.entities.*;
import mypak.dao.*;


import org.junit.Test;

public class AddUsers {
	
	
	
	@Test
	public void addUserTest() {
		
		User user = new User();
			
		user.setName("DINESH");		
		user.setEmail("DINESH@CYBAGE.COM");
		user.setPassword("DINESH@123");
		user.setGender("M");	
		
		UserDaoImpl UserDao = new UserDaoImpl();
		boolean result= UserDao.addUser(user);
		
		assertEquals(true, result);
		
	}
	
}
