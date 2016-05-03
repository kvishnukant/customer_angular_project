package mypak.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import mypak.entities.ClientData;
import mypak.entities.Role;
import mypak.entities.User;

public class RolesDaoImpl implements RolesDao {
	
	private EntityManager em;
	 private static final String PERSISTENCE_UNIT_NAME = "todos";
	 private static EntityManagerFactory factory;
	
	@Override
	public boolean addRoles(Role newRole) {
		
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    em = factory.createEntityManager();
	    em.getTransaction().begin();
	   // Role role = new Role(newRole.getName(),newRole.getDescription(),newRole.getStatus(),newRole.getPermissions(),newRole.getType());
	    em.persist(newRole);
	    em.getTransaction().commit();
	    em.close();
		
	    return true;
	}

	
	
	@Override
	public boolean deleteRole(int roleid) {
	
factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    
		em = factory.createEntityManager();
	    em.getTransaction().begin();
	    Query query = em.createQuery("delete from Role where roleid = '"+roleid+"'");
		
		    int deleted = query.executeUpdate();
		em.getTransaction().commit();
		em.close();
		
		if(deleted!=0)
            return true;
        else 
            return false;

	}

	@Override
	public List<Role> showRoles() {
		
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = factory.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select role from Role role");
		@SuppressWarnings("unchecked")
		List<Role> list = query.getResultList();
		return list;
	}
	
}
