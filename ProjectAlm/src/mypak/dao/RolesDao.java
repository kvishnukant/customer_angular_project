package mypak.dao;

import java.util.List;

import mypak.entities.Role;



public interface RolesDao {

	boolean addRoles(Role newRole);
	boolean deleteRole(int roleid);
	List<Role> showRoles();
}
