package com.sandeep.security.springJersey.filter;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import com.sandeep.security.springJersey.appRoles.RolesConstant;
/**
 * This filter verify the access permissions for a user based on
 * user name and password provided in request
 * */
@Provider
public class SecurityFilter implements ContainerRequestFilter
{

	private static final Response ACCESS_DENIED = Response.status(Response.Status.UNAUTHORIZED)
			.build();
	private static final Response ACCESS_FORBIDDEN = Response.status(Response.Status.FORBIDDEN)
			.build();
	

	@Context
	private ResourceInfo resourceInfo;

	
	



	public void filter(ContainerRequestContext requestContext) throws IOException
	{
		
		Method method = resourceInfo.getResourceMethod();
		// Access allowed for all
		if (!method.isAnnotationPresent(PermitAll.class))
		{
			// Access denied for all
			if (method.isAnnotationPresent(DenyAll.class))
			{
				requestContext.abortWith(ACCESS_FORBIDDEN);
				return;
			}
			

			final String username = System.getProperty("user.name");
			
			
			// Verify user access
			if (method.isAnnotationPresent(RolesAllowed.class))
			{
				RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
				Set<String> rolesSet = new HashSet<String>(Arrays.asList(rolesAnnotation.value()));

				// Is user valid?
				if (!isUserAllowed(username, rolesSet))
				{
					requestContext.abortWith(ACCESS_DENIED);
					return;
				}
			}
		}
	}
	private boolean isUserAllowed(final String username, final Set<String> rolesSet)
	{
		List<String> userRoles = RolesConstant.userRoleMapping.get(username); //Get the roles associated with user from DB or from auth webservice. For Demo purpose it is hardcoded. 
		return userRoles.stream().anyMatch(aRole -> rolesSet.contains(aRole));
		
	}

}
