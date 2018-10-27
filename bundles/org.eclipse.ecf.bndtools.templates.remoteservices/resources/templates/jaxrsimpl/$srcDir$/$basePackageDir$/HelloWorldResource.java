package $basePackageName$;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import $apipackage$.HelloWorldService;
import org.osgi.service.component.annotations.Component;

@Path("/helloworld")
@Component(property = { "service.exported.interfaces=*", "service.exported.intents=jaxrs" })
public class HelloWorldResource implements HelloWorldService {
	@GET
	@Path("/hello")
	@Produces("text/plain")
	public String getMessage() {
		System.out.println("HelloWorldResource.getMessage() called");
		return "Hello OSGi World";
	}
}