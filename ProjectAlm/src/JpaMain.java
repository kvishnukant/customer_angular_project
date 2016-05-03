import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import mypak.entities.ClientData;
import mypak.entities.Group;
import mypak.entities.Role;
import mypak.entities.User;



 
public class JpaMain {
 
    /**
     * @param args
     */
    public static void main(String[] args) {
    	
    	//@PersistenceUnit
    	//EntityManagerFactory emf;
    	
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("todos");
        EntityManager em = emf.createEntityManager();	
 
        System.out.println("Creating Database.....");
        try 
        {
            em.getTransaction().begin();
             
            ClientData c= new ClientData();
           
            c.setName("OpenTravel");
            c.setAddress("USA");
            c.setCTO("Mrs");
            c.setCEO("dishank");
           	c.setDescription("MobileApp");
            c.setNoOfEmployees(100);
            c.setRevenue(60);
            c.setPoc("123456789");
            c.setDomainList("Traveling");
            c.setStatus("Active");
          
            
           
            User user = new User();
            user.setName("ABC");
            user.setEmail("abc@gmail.com");
            user.setPassword("abc@123");
            user.setGender("M");
                       
            Role r = new Role();
            r.setName("SE");            
            Group g=new Group();
            g.setName("GroupA");
            g.setDescription("Task A");
            g.setStatus("Active");
            g.setPermission1("Read & Write");
            
            em.persist(c);         
            em.persist(user);           
            em.persist(r);
            em.persist(g);
            em.getTransaction().commit();
        }
        catch (Exception e) {
           // em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally{
            emf.close();
        }
         
        System.out.println("Database Created Successfully");
    
    }
}