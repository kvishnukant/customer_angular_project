package mypak.dao;

import java.io.Serializable;
import java.util.List;
import mypak.entities.User;

public interface UserDao extends Serializable 
{

	boolean addUser(User newUser);
	boolean deleteuser(int id);
	boolean updateUser(User updateUser);
	List<User> showUsers();
}
