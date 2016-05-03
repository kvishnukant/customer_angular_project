package mypak.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import mypak.dao.RolesDao;
import mypak.dao.RolesDaoImpl;
import mypak.entities.Role;

import com.sun.jersey.api.client.ClientResponse.Status;

@Path("/roleService")
public class RoleController
{
	private static Logger logger = Logger.getLogger(RoleController.class);

	//================== For Role ====================
					
			
			@POST
			@Consumes(MediaType.APPLICATION_JSON)
			@Produces(MediaType.APPLICATION_JSON)
			@Path("/role")
			public Response addRole(mypak.entities.Role newRole)
			{
				logger.info("in add role");
				Response.ResponseBuilder res =null;
				String json = "{'OK'}";
				System.out.println("in add role");					
			
				RolesDao rolesDao = new RolesDaoImpl();					
				boolean role = rolesDao.addRoles(newRole);
				
			//	res.entity(new Role());
			// 	res = Response.status(Status.OK);
				res =  Response.status(Status.OK);
			    return res.build(); 
				 
			}
			
		// ========= Retrieving Role Details	
			@GET
			@Path("/roleDetails")
			@Produces(MediaType.APPLICATION_JSON)
			public Response showRoles()
			{
				logger.info("in show role");
				 String json = "{'OK'}";
				 System.out.println("in get role");
				 
				 RolesDao rolesDao = new RolesDaoImpl();
				
				 List<Role> list = rolesDao.showRoles();
				
				 
				 System.out.println(list);
				 
				 Response.ResponseBuilder res = Response.status(Status.OK);
		         GenericEntity<List<Role>> entity = new GenericEntity<List<Role>>(list) {};
		         res.entity(entity);
		         return res.build();

				 
				 
				 }

}
