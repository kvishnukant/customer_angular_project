package mypak.dao;


import java.util.List;

import javax.persistence.*;

import mypak.entities.ClientData;
import mypak.entities.User;

public class ClientDaoImpl implements ClientDao {

	private EntityManager em;
	 private static final String PERSISTENCE_UNIT_NAME = "todos";
	 private static EntityManagerFactory factory;
	
	@Override
	public boolean addClient(ClientData newClient) {
		// TODO Auto-generated method stub
		
		try {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			em = factory.createEntityManager();
			em.getTransaction().begin();
			
			ClientData client = new ClientData(newClient.getName(),newClient.getAddress(),newClient.getEmail(),newClient.getDomainList(),newClient.getDescription(),newClient.getRevenue(),newClient.getNoOfEmployees(),newClient.getPresence(),newClient.getCEO(),newClient.getCTO(),newClient.getPoc(),newClient.getOffices(),newClient.getStatus());
			System.out.println(newClient);
			em.persist(client); 
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   finally
	   {
		   em.close();
	   }
		
		return true;
	}
	
	

	@Override
	public boolean deleteClient(int removeClient) {
		// TODO Auto-generated method stub
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    em = factory.createEntityManager();
	    em.getTransaction().begin();
	    Query query = em.createQuery("delete from ClientData where clientid = '"+removeClient+"'");
		
	    int deleted = query.executeUpdate();
		em.getTransaction().commit();
		em.close();
		
		if(deleted!=0)
            return true;
        else 
            return false;

	}



	@Override
	public List<ClientData> showClients() {

		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    em = factory.createEntityManager();
	    em.getTransaction().begin();
		Query query = em.createQuery("select client from ClientData client");
		List<ClientData> list=query.getResultList();
		return list;
	}
	
	@Override
	public boolean updateClient(ClientData updateClient) {

		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    em = factory.createEntityManager();
	    em.getTransaction().begin();
	    
	    em.merge(updateClient);
	    /*Query query = em.createQuery("update ClientData client SET client.name = ?, client.address = ?,client.domainList=?,client.description=?,client.revenue=?,client.noOfEmployees=?,client.presence=?,client.CEO=?,client.CTO=?,client.poc = ?,client.offices=?,client.status=? where clientid = ?");
	    query.setParameter(0, updateClient.getName());
	    query.setParameter(1,updateClient.getAddress());
	    query.setParameter(2, updateClient.getDomainList());
	    query.setParameter(3, updateClient.getDescription());
	    query.setParameter(4, updateClient.getRevenue());
	    query.setParameter(5, updateClient.getNoOfEmployees());
	    query.setParameter(6, updateClient.getPresence());
	    query.setParameter(7, updateClient.getCEO());
	    query.setParameter(8, updateClient.getCTO());
	    query.setParameter(9, updateClient.getPoc());
	    query.setParameter(10, updateClient.getOffices());
	    query.setParameter(11, updateClient.getStatus());
	    query.setParameter(12,updateClient.getClientid());
	    query.executeUpdate();*/
	    em.getTransaction().commit();
	    em.close();
		return true;
	}



	@Override
	public List<ClientData> getClient(int id) {
		// TODO Auto-generated method stub
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    em = factory.createEntityManager();
	    em.getTransaction().begin();
		Query query = em.createQuery("select client from ClientData client where clientid='"+id+"'");
		
		List<ClientData> list=query.getResultList();
		
		return list;
	}
	
}
