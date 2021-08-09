package com.sandeep.security.springJersey.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.sandeep.security.springJersey.endpoint.SayHello;
import com.sandeep.security.springJersey.filter.SecurityFilter;
 
@ApplicationPath("/api")
@Configuration
@Component
public class JerseyConfig extends ResourceConfig 
{
    public JerseyConfig() 
    {
    	register(SecurityFilter.class);
        register(SayHello.class);
    }
}
