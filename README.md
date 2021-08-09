# SpringSecurityJersey
<b>Endpoint:</b> Instead of @RequestMapping and @RestController <br/>
@Path("/hello")<br/>
public class SayHello {<br/><br/>

<b>Method:</b> Instead of @GetMapping , @PathVariable<br/>
@Path("/{name}")<br/>
	@GET<br/>
	@RolesAllowed({_HelloRole, _AdminRole})<br/>
	public String sayHello(@PathParam("name") String name) {<br/><br/>
  
<b>Filter:</b> Create filter<br/>
@Provider<br/>
public class SecurityFilter implements ContainerRequestFilter{<br/>
@Context<br/>
private ResourceInfo resourceInfo;<br/>
public void filter(ContainerRequestContext requestContext) throws IOException<br/>
	{<br/>
}<br/><br/>

<b>Glue: </b>Glue the Security filter and Endpoint<br/>
@ApplicationPath("/api")<br/>
@Component<br/>
public class JerseyConfig extends ResourceConfig <br/>
{<br/>
    public JerseyConfig() <br/>
    {<br/>
    	register(SecurityFilter.class);<br/>
        register(SayHello.class);<br/>
    }<br/>
}<br/>
