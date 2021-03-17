package $basePackageName$;

/**
 * This is an example remote service declaration. This service interface is
 * implemented by the remote service 'provider' or 'host', and is typically
 * injected for use by consumers that call service methods.
 * </p>
 * <p>
 * For this example, no methods are define. This is where the service contract
 * is defined by the remote service developer.
 * </p>
 * <p>
 * <b>Note</b>: <a href="https://osgi.org/specification/osgi.cmpn/7.0.0/service.remoteservices.html">OSGi R7 Remote Services</a> allows the use of two standardized intents that change the
 * remote service distribution provider's interpretation and serialization of
 * the argument and return types:
 * </p>
 * <ul>
 * <li><a href="https://osgi.org/specification/osgi.cmpn/7.0.0/service.remoteservices.html#service.remoteservices-osgi.basic">osgi.basic</a></li>
 * <li><a href="https://osgi.org/specification/osgi.cmpn/7.0.0/service.remoteservices.html#d0e1402">osgi.async</a></li>
 * </ul>
 * <p>
 * See <a href="https://wiki.eclipse.org/Eclipse_Communication_Framework_Project#OSGi_Remote_Services">ECF's Remote Services Tutorials</a>
 * for tutorials on declaring, implementing, and testing OSGi Remote Services
 * </p>
 */
public interface HelloService {

	String hello(String from);
	
}