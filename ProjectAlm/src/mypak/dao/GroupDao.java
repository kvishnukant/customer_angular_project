package mypak.dao;

import java.util.List;

import mypak.entities.Group;




public interface GroupDao {

	boolean addGroups(Group newGroup);
	boolean deleteGroups(int groupid);
	List<Group> showGroups();
}
