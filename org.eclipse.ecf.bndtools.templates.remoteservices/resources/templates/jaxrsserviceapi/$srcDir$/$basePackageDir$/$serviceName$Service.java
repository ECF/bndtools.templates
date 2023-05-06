package $basePackageName$;

import java.util.concurrent.CompletableFuture;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * This is an example jaxrs remote service declaration.
 * <p>
 * See <a href=
 * "https://wiki.eclipse.org/Eclipse_Communication_Framework_Project#OSGi_Remote_Services">ECF's
 * Remote Services Tutorials</a> for tutorials on declaring, implementing, and
 * testing OSGi Remote Services
 * </p>
 * <p>
 * For documentation on JaxRS Remote Services see <a href="">OSGi Remote
 * Services JaxRS Distribution Providers</a>
 * </p>
 */
@Path("/$serviceName$")
public interface $serviceName$Service {

	@GET
	@Path("/getmessage")
	String getMessage(@QueryParam("fromMessage") String fromMessage);

	@GET
	@Path("/getmessageasync")
	CompletableFuture<String> getMessageAsync(@QueryParam("fromMessage") String fromMessage);

}
