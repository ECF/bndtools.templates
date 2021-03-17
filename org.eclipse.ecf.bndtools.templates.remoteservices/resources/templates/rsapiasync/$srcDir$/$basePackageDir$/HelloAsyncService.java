package $basePackageName$;

import java.util.concurrent.CompletableFuture;

/**
 * This is an example osgi.async remote service declaration. This service interface is
 * implemented by the remote service 'provider' or 'host', and is typically
 * injected for use by consumers that call service methods.  It uses the 
 * OSGi R7 osgi.async service intent.
 * </p>
 * <p>
 * See <a href="https://osgi.org/specification/osgi.cmpn/7.0.0/service.remoteservices.html#d0e1407">here for info on osgi.async remote service intent</a>
 * </p>
 * <p>
 * See <a href="https://wiki.eclipse.org/Eclipse_Communication_Framework_Project#OSGi_Remote_Services">ECF's Remote Services Tutorials</a>
 * for tutorials on declaring, implementing, and testing OSGi Remote Services
 * </p>
 */
public interface HelloAsyncService {

	CompletableFuture<String> hello(String from);

}