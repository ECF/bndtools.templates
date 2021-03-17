package $basePackageName$;

import java.util.concurrent.CompletableFuture;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.osgi.service.component.annotations.Component;

import $api_package$.HelloWorldService;

@Component(property = { "service.exported.interfaces=*", 
		"service.exported.intents=jaxrs",
		"service.exported.intents=osgi.async",
		"ecf.jaxrs.jersey.server.pathPrefix=/rs" })
@Path("/helloworld")
public class HelloWorldResource implements HelloWorldService {

	@GET
	@Path("/hello")
	public String getMessage(@QueryParam("fromMessage") String fromMessage) {
		System.out.println("HelloWorldResource.getMessage() called with fromMessage="+fromMessage);
		return "Server response:  Hello OSGi World";
	}

	@GET
	@Path("/helloasync")
	public CompletableFuture<String> getMessageAsync(@QueryParam("fromMessage") String fromMessage) {
		CompletableFuture<String> resultCF = new CompletableFuture<String>();
		resultCF.complete(getMessage(fromMessage));
		return resultCF;
	}

}
