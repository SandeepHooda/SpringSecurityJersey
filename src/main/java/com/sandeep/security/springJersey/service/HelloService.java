package com.sandeep.security.springJersey.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service("HelloService")
public class HelloService {
	 @Autowired
	 private Environment environment;
	 
	 @Value("${dbName:not spedified}")
	 private String dbName;
	
	public String sayHello( String name) {
		 for (String profileName : environment.getActiveProfiles()) {
	            System.out.println("Currently active profile - " + profileName);
	        }  
		System.out.println(" dbName name "+dbName);
		System.out.println("Inside service class name is: "+name);
		return "Hello "+name;
	}

}
