package mypak.controller;


import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManagerFactory;
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


import com.sun.jersey.api.client.ClientResponse.Status;


import mypak.dao.ClientDao;
import mypak.dao.ClientDaoImpl;
import mypak.dao.GroupDao;
import mypak.dao.GroupDaoImpl;
import mypak.dao.RolesDao;
import mypak.dao.RolesDaoImpl;

import mypak.dao.UserDao;
import mypak.dao.UserDaoImpl;
import mypak.entities.ClientData;
import mypak.entities.Group;
import mypak.entities.Role;
import mypak.entities.User;


@Path("/groupService")
public class GroupController {

	
	private static Logger logger = Logger.getLogger(GroupController.class);		
	
	
	
	
				
				
				//============For adding groups===============
				@POST
				@Consumes(MediaType.APPLICATION_JSON)
				@Produces(MediaType.APPLICATION_JSON)
				@Path("/addgroup")
				public Response addGroups(Group newGroup)
				{
					logger.info("In Add Groups Methods");
					Response.ResponseBuilder res =null;
					String json = "{'OK'}";
					System.out.println("in add group");					 					
					
					GroupDao groupDao = new GroupDaoImpl();					
					boolean group = groupDao.addGroups(newGroup);
					
					res =  Response.status(Status.OK);
					
				//	res.entity(new Group());
				//	res = Response.status(Status.OK);
					
					return res.build(); 
					 
				}
				//=================== For Retrieving Groups ==================
				@GET
				@Path("/groupDetails")
				@Produces(MediaType.APPLICATION_JSON)
				public Response showGroups()
				{
					logger.info("In showGroups Methods");
					 String json = "{'OK'}";
					 System.out.println("in getGroups");
					 GroupDao groupDao=new GroupDaoImpl();
					 List<Group> list=groupDao.showGroups();
					 
					 System.out.println(list);
					 
					 Response.ResponseBuilder res = Response.status(Status.OK);
			         GenericEntity<ArrayList<Group>> entity = new GenericEntity<ArrayList<Group>>((ArrayList<Group>) list) {};
			         res.entity(entity);
			         return res.build();

					 
					 
					 }
		
				
				
}
