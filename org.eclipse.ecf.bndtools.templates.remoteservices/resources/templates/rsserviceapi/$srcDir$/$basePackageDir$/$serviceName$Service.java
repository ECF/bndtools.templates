package $basePackageName$;

/**
 * This is an example OSGi Async Remote Service declaration.
 * <p>
 * See <a href=
 * "https://osgi.org/specification/osgi.cmpn/7.0.0/service.remoteservices.html#d0e1407">here</a>
 * for the specification of OSGi Async Remote Services
 * </p>
 */
public interface $serviceName$Service {

	String callsync(String from);
	
}