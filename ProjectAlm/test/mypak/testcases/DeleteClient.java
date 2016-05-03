package mypak.testcases;

import static org.junit.Assert.*;

import org.junit.Test;


import mypak.dao.*;


public class DeleteClient {

	
	@Test
	public void deleteClientTest()
	{
		
		ClientDaoImpl ClientDao = new ClientDaoImpl();
		boolean result= ClientDao.deleteClient(1);
		
		assertEquals(true, result);
		
	}
}
