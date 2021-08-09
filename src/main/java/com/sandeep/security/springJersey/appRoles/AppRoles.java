package com.sandeep.security.springJersey.appRoles;

import static com.sandeep.security.springJersey.appRoles.RolesConstant.*;

public enum AppRoles {
	
	HelloRole(_HelloRole),
	AdminRole(_AdminRole);
	
	private String roleDesc;
	private AppRoles(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public String getRoleDesc() {
		return roleDesc;
	}

	
}
