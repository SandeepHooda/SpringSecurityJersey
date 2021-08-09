package com.sandeep.security.springJersey.endpoint;

import static com.sandeep.security.springJersey.appRoles.RolesConstant._AdminRole;
import static com.sandeep.security.springJersey.appRoles.RolesConstant._HelloRole;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.springframework.stereotype.Component;

@Path("/hello")
@Component
public class SayHello {
	
	//Use postman with url http://localhost:8080/api/hello/sandeep
	//Basic auth user : admin
	//password: password
	@Path("/{name}")
	@GET
	@RolesAllowed({_HelloRole, _AdminRole})
	public String sayHello(@PathParam("name") String name) {
		System.out.println("name is: "+name);
		return "Hello "+name;
	}

}
