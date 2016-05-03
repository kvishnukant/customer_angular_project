package mypak.controller;

import java.util.ArrayList;
import java.util.List;

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

import mypak.dao.UserDao;
import mypak.dao.UserDaoImpl;
import mypak.entities.User;

import com.sun.jersey.api.client.ClientResponse.Status;

@Path("/userService")
public class UserController
{
	private static Logger logger = Logger.getLogger(UserController.class);
	//------------- Get User Data----------------
	
		@GET
		@Path("/user")
		@Produces(MediaType.APPLICATION_JSON)
		public Response showUsers()
		{
			logger.info("In showUser Function");
			 String json = "{'OK'}";
			 System.out.println("in getrole");
			 UserDao userDao=new UserDaoImpl();
			 List<User> list=userDao.showUsers();
			 
			 System.out.println(list);
			 
			 Response.ResponseBuilder res = Response.status(Status.OK);
	         GenericEntity<ArrayList<User>> entity = new GenericEntity<ArrayList<User>>((ArrayList<User>) list) {};
	         res.entity(entity);
	         return res.build();

			 
			 
		}
		
		//============For adding user===============
				@POST
				@Consumes(MediaType.APPLICATION_JSON)
				@Produces(MediaType.APPLICATION_JSON)
				@Path("/adduser")
				public Response addUser(User newUser)
				{
					logger.info("In addUser Function");
					Response.ResponseBuilder res =null;
					String json = "{'OK'}";
					 System.out.println("in add user");
					 
					
				
					
					UserDao userDao = new UserDaoImpl();
						 //ClientDao clientDao=new ClientDaoImpl();
					//	 boolean client=clientDao.addClient(newClient);
						
					boolean user = userDao.addUser(newUser);
						res =  Response.status(Status.OK);
					
						res.entity(new User());
				//	 res = Response.status(Status.OK);
					
						 return res.build(); 
					 
				}
				
				//========Updating user records==================
						@PUT
						@Path("/userUpdate")
						@Produces(MediaType.APPLICATION_JSON)
						@Consumes(MediaType.APPLICATION_JSON)
						public Response getResource(User updateUser)
						{
							logger.info("In get User Function");
							String json = "{'OK'}";
							System.out.println("in get res");
							UserDao userDao = new UserDaoImpl();
							boolean result = userDao.updateUser(updateUser);
							//boolean result=resourceDao.updateResource(resource);
							return Response.status(200).type("application/json").entity(json).build(); 
						}
						
				
						
				//=========For deleting user=========
				
						@DELETE
						@Path("/deleteUser/{id}")
						@Produces(MediaType.APPLICATION_JSON)
						@Consumes(MediaType.APPLICATION_JSON)
						public Response deleteUser(@PathParam("id") int id)
						{
							String json = "{'OK'}";
							System.out.println("in delete user "+id);
							
							UserDao userDao = new UserDaoImpl();
							userDao.deleteuser(id);
							
							 System.out.println("hii after dao"+id);
							Response.ResponseBuilder res = Response.status(Status.OK);
					        // GenericEntity<List<ClientData>> entity = new GenericEntity<List<ClientData>>(list) {};
					         res.entity("Deleted");
					         return res.build();	
					         
						}
		
}
