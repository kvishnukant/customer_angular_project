package mypak.testcases;

import static org.junit.Assert.*;


import mypak.dao.GroupDaoImpl;

import org.junit.Test;

public class DeleteGroup {

	@Test
	public void deleteClientGroupTest()
	{
		
		GroupDaoImpl GroupDao = new GroupDaoImpl();
		boolean result= GroupDao.deleteGroups(10);
		
		assertEquals(true, result);
		
	}

}
