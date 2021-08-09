package com.sandeep.security.springJersey.endpoint;

import static com.sandeep.security.springJersey.appRoles.RolesConstant._AdminRole;
import static com.sandeep.security.springJersey.appRoles.RolesConstant._HelloRole;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

@Path("/hello")
@Component
@Consumes({ MediaType.APPLICATION_JSON + "; charset=UTF-8" })
@Produces({ MediaType.APPLICATION_JSON + "; charset=UTF-8" })
public class SayHello {
	
	@Path("/{name}")
	@GET
	@RolesAllowed({_HelloRole, _AdminRole})
	public String sayHello(@PathParam("name") String name) {
		System.out.println("name is: "+name);
		return "Hello "+name;
	}

}
