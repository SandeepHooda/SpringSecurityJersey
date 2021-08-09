package com.sandeep.security.springJersey.service;

import org.springframework.stereotype.Service;

@Service("HelloService")
public class HelloService {
	
	public String sayHello( String name) {
		System.out.println("Inside service class name is: "+name);
		return "Hello "+name;
	}

}
