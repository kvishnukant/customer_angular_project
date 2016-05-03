package mypak.testcases;

import static org.junit.Assert.*;

import mypak.dao.GroupDaoImpl;
import mypak.entities.Group;

import org.junit.Test;

public class AddGroup {

	@Test
	public void addGroupTest() {
		
		Group group = new Group();
		
		
		
		group.setName("PARAS");
		group.setDescription("ABC");
		group.setStatus("ACTIVE");
		group.setPermission1("WRITE");
		group.setPermission2("READ");
		
		GroupDaoImpl GroupDao = new GroupDaoImpl();
		boolean result= GroupDao.addGroups(group);
		
		assertEquals(true, result);
	}

}
