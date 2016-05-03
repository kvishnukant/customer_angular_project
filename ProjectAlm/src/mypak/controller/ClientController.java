package mypak.controller;

import java.util.ArrayList;
import java.util.List;
//import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import mypak.dao.ClientDao;
import mypak.dao.ClientDaoImpl;
import mypak.entities.ClientData;
import com.sun.jersey.api.client.ClientResponse.Status;

@Path("/clientService")
public class ClientController
{
//	private static EntityManagerFactory factory;
	
	//=======================Saving Client Record==================
	private static Logger logger = Logger.getLogger(ClientController.class);
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/client")
	public Response addClient(ClientData newClient)
	{
		logger.info("In addClient method");
		Response.ResponseBuilder res =null;
		//String json = "{'OK'}";
		System.out.println("In clientService POST");		
		ClientDao clientDao=new ClientDaoImpl();
		clientDao.addClient(newClient);		//boolean client=clientDao.addClient(newClient);
		res =  Response.status(Status.OK);
		return res.build(); 		 
	}  
	
	//=======================Getting Client Records==================
	
	@GET
	@Path("/clientDetails")
	@Produces(MediaType.APPLICATION_JSON)
	public Response showClients()
	{
		logger.info("In showClients method");
		 String json = "{'OK'}";
		 System.out.println("In clientService GET");
		 ClientDao clientDao =  new ClientDaoImpl();
		 ArrayList<ClientData> list =  (ArrayList<ClientData>) clientDao.showClients();		 		 		
		 Response.ResponseBuilder res = Response.status(Status.OK);
		 GenericEntity<ArrayList<ClientData>> entity = new GenericEntity<ArrayList<ClientData>>((ArrayList<ClientData>) list) {};		 
         res.entity(entity);
         return res.build();	
	}
	
	//=======================Updating Client Records==================
	
	@PUT
	@Path("/clientUpdate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateClient(ClientData updateClient )
	{
		logger.info("In updateClient method");
		String json = "{'OK'}";
		System.out.println("in update client");
		ClientDao clientDao=new ClientDaoImpl();
		clientDao.updateClient(updateClient);//boolean result = clientDao.updateClient(updateClient);		
		return Response.status(200).type("application/json").entity(json).build(); 
	}
	
	//====================== Get Client By Id =====================
	
	@GET
	@Path("/getClientById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getClient(@PathParam("id") int id)
	{
		logger.info("In getClient method");
		String json = "{'OK'}";
		System.out.println("in get by id"+id);
		ClientDao clientDao = new ClientDaoImpl();
		ArrayList<ClientData> list =  (ArrayList<ClientData>) clientDao.getClient(id);
		System.out.println("List "+list);
		Response.ResponseBuilder res = Response.status(Status.OK);
        GenericEntity<List<ClientData>> entity = new GenericEntity<List<ClientData>>(list) {};
        res.entity(entity);
        return res.build();			
	}
	
	//====================== Delete Client By Id =====================
	
	@DELETE
	@Path("/deleteClient/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteClient(@PathParam("id") int id)
	{
		logger.info("In deleteClient method");
		String json = "{'OK'}";
		System.out.println("in delete client "+id);				
		ClientDao clientDao = new ClientDaoImpl();				
		clientDao.deleteClient(id);
		Response.ResponseBuilder res = Response.status(Status.OK);		        
	    res.entity("Deleted");
	    return res.build();
	}

}
