package com.sandeep.security.springJersey.appRoles;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class RolesConstant {

	public static final String _HelloRole = "HelloRole";
	public static final String _AdminRole = "AdminRole";
	public static final String _MathAdd = "MathAdd";
	
	public static  Map<String, List<String>> userRoleMapping = new HashMap<String, List<String>>();
	
	static {
		userRoleMapping.put("shaurya", Arrays.asList(_MathAdd));
	}
}
