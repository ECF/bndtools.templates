package $basePackageName$;

import java.util.concurrent.CompletableFuture;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * This is an example jaxrs remote service declaration. This service interface is
 * implemented by the remote service 'provider' or 'host', and is typically
 * injected for use by consumers that call service methods.
 * </p>
 * <p>
 * See <a href="https://wiki.eclipse.org/Eclipse_Communication_Framework_Project#OSGi_Remote_Services">ECF's Remote Services Tutorials</a>
 * for tutorials on declaring, implementing, and testing OSGi Remote Services
 * </p>
 */
@Path("/helloworld")
public interface HelloWorldService {

	@GET
	@Path("/hello")
	String getMessage(@QueryParam("fromMessage") String fromMessage);

	@GET
	@Path("/helloasync")
	CompletableFuture<String> getMessageAsync(@QueryParam("fromMessage") String fromMessage);

}
