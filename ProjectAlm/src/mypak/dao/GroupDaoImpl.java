package mypak.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import mypak.entities.Group;
import mypak.entities.Role;

public class GroupDaoImpl implements GroupDao {

	private EntityManager em;
	 private static final String PERSISTENCE_UNIT_NAME = "todos";
	 private static EntityManagerFactory factory;
	 
	@Override
	public boolean addGroups(Group newGroup) {
		// TODO Auto-generated method stub
		
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    em = factory.createEntityManager();
	    em.getTransaction().begin();
	    Group group = new Group(newGroup.getName(),newGroup.getDescription(),newGroup.getStatus(),newGroup.getPermission1(),newGroup.getPermission2());
	    em.persist(group);
	    em.getTransaction().commit();
	    em.close();
		return true;
	}
	


	@Override
	public boolean deleteGroups(int groupid) {
		// TODO Auto-generated method stub
factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    
		em = factory.createEntityManager();
	    em.getTransaction().begin();
	    Query query = em.createQuery("delete from Group where groupid = '"+groupid+"'");
		
	    int deleted = query.executeUpdate();
	em.getTransaction().commit();
	em.close();
	
	if(deleted!=0)
        return true;
    else 
        return false;

	}
	
	

	@Override
	public List<Group> showGroups() {
		// TODO Auto-generated method stub
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = factory.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select Group from Group group");
		@SuppressWarnings("unchecked")
		List<Group> list = query.getResultList();
		return list;
	}
	
	
}
