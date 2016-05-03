package mypak.testcases;

import static org.junit.Assert.*;


import org.junit.Test;

import mypak.entities.*;
import mypak.dao.*;


public class AddClient 
{	
	@Test
	public void addClientTest() {
		
		
		
		ClientData client = new ClientData();
		
		client.setName("GOOGLE");
		client.setAddress("USA");
		client.setEmail("ADMIN@GOOGLE.COM");		
		client.setDomainList("MEDIA & ENTERTAINMENT");
		client.setDescription("GMAIL APP");
		client.setRevenue(100000);
		client.setNoOfEmployees(100000);
		client.setPresence("USA");
		client.setCEO("LARY PAGE");
		client.setCTO("SERGEY BRIN");
		client.setPoc("1234567890");
		client.setOffices("USA");
		client.setStatus("ACTIVE");
		ClientDaoImpl ClientDao = new ClientDaoImpl();
		boolean result= ClientDao.addClient(client);
		
		assertEquals(true, result);
		
	}

}
