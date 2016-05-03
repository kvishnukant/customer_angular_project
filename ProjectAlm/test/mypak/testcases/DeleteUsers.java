package mypak.testcases;

import static org.junit.Assert.*;



import mypak.dao.*;


import org.junit.Test;

public class DeleteUsers {
	
	
	@Test
	public void deleteUserTest()
	{
		
		UserDaoImpl UserDao = new UserDaoImpl();
		boolean result= UserDao.deleteuser(1);
		
		assertEquals(true, result);
		
	}
}
