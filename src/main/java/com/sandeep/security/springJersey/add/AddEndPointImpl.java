package com.sandeep.security.springJersey.add;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sandeep.security.springJersey.utils.MathVO;
import static com.sandeep.security.springJersey.appRoles.RolesConstant.*;

@RestController
@Path("/math")
public class AddEndPointImpl {
	
	@Path("/add")
	@POST
	@RolesAllowed({_MathAdd})
	
	public int add (@RequestBody() MathVO vo) {
		return vo.getA() +vo.getB();
	}

}
