package mypak.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



import mypak.entities.User;

public class UserDaoImpl implements UserDao{

	
	private static final long serialVersionUID = 1L;
	private EntityManager em;
	private static final String PERSISTENCE_UNIT_NAME = "todos";
	private static EntityManagerFactory factory;
	
	// Add New User 
	
	@Override
	public boolean addUser(User newUser) 
	{
	
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    em = factory.createEntityManager();
	    em.getTransaction().begin();
	    
	    em.persist(newUser);
	    
	    em.getTransaction().commit();
	    em.close();		
		return true;
	}

	// Delete User By Id
	
	@Override
	public boolean deleteuser(int userid) 
	{				
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    em = factory.createEntityManager();
	    em.getTransaction().begin();
	    Query query = em.createQuery("delete from User where userid = '"+userid+"'");
	 // em.remove(removeUser);
	    int deleted = query.executeUpdate();
	    System.out.println("User with id :"+deleted+" is deleted");
		em.getTransaction().commit();
		em.close();				
		if(deleted!=0)
            return true;
        else 
            return false;

	}

	// Get All Users
	
	@Override
	public List<User> showUsers() {
		
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    em = factory.createEntityManager();
	    em.getTransaction().begin();
		Query query = em.createQuery("select user from User user");
		List<User> list=query.getResultList();
		return list;
	}
	
	
	
	// Update user data
	
	@Override
	public boolean updateUser(User updateUser)
	{		
		
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    em = factory.createEntityManager();
	    em.getTransaction().begin();
	    Query query=em.createQuery("update User user SET user.name= ?,user.gender= ?,user.email= ?,user.password= ? where userId= ?");
	    query.setParameter(1,updateUser.getName());
	    query.setParameter(2,updateUser.getGender());
	    query.setParameter(3,updateUser.getEmail());
	    query.setParameter(4,updateUser.getPassword());
	    query.setParameter(5,updateUser.getUserid());
	    query.executeUpdate();
	    em.getTransaction().commit();
		em.close();	    
		return true;
	}
}
