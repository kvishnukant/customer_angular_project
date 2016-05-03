package mypak.testcases;

import static org.junit.Assert.*;


import mypak.entities.*;
import mypak.dao.*;

import org.junit.Test;

public class AddRoles {

	@Test
	public void addRoleTest() {
		
		Role role = new Role();		
		role.setName("SHUBHAM");
		role.setDescription("GROUP2");
		role.setStatus("ACTIVE");
		role.setRoletype("SYSTEM ADMIN");		
		RolesDaoImpl RolesDao = new RolesDaoImpl();
		boolean result= RolesDao.addRoles(role);		
		assertEquals(true, result);
		
	}

}
