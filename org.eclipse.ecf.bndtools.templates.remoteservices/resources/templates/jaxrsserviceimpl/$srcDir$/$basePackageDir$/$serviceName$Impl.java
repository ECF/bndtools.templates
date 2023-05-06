package $basePackageName$;

import java.util.concurrent.CompletableFuture;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.osgi.service.component.annotations.Component;

import $api_package$.$serviceName$Service;

@Component(property = { "service.exported.interfaces=*", "service.exported.intents=jaxrs",
		"service.exported.intents=osgi.async", "ecf.jaxrs.jersey.server.pathPrefix=/rs" })
@Path("/$serviceName$")
public class $serviceName$Impl implements $serviceName$Service {

	@GET
	@Path("/getmessage")
	public String getMessage(@QueryParam("fromMessage") String fromMessage) {
		System.out.println("HelloWorldResource.getMessage() called with fromMessage=" + fromMessage);
		return "Server response:  Hello OSGi World";
	}

	@GET
	@Path("/getmessageasync")
	public CompletableFuture<String> getMessageAsync(@QueryParam("fromMessage") String fromMessage) {
		return CompletableFuture.completedFuture(getMessage(fromMessage));
	}

}
