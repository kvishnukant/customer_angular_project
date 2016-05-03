package mypak.testcases;

import static org.junit.Assert.*;



import mypak.dao.*;

import org.junit.Test;

public class DeleteRoles {

	
	@Test
	public void deleteRoleTest()
	{
		
		RolesDaoImpl RolesDao = new RolesDaoImpl();
		boolean result= RolesDao.deleteRole(2);
		
		assertEquals(true, result);
		
	}
	

}
