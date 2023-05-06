package $basePackageName$;

import java.util.concurrent.CompletableFuture;

/**
 * This is an example OSGi Async Remote Service declaration.
 * <p>
 * See <a href=
 * "https://osgi.org/specification/osgi.cmpn/7.0.0/service.remoteservices.html#d0e1407">here</a>
 * for the specification of OSGi Async Remote Services
 * </p>
 */
public interface $serviceName$Service {

	/**
	 * As per <a href=
	 * "https://docs.osgi.org/specification/osgi.cmpn/7.0.0/service.remoteservices.html#d0e1424">OSGi
	 * Companion section 100.3.2.1 - Supported Return Types</a> if the return type
	 * for this method is one of <b>CompleteableFuture</b>, <b>CompletionStage</b>,
	 * <b>Future</b>, or <b>Promise</b> then and the remote service has been
	 * exported with the <a href=
	 * "https://docs.osgi.org/specification/osgi.cmpn/7.0.0/service.remoteservices.html#d0e1407">osgi.async
	 * intent</a>, then then the remote invocation of this method will be done
	 * asynchronously, and with timeout optionally specified by the exported
	 * implementation.
	 * 
	 * @param from A name for the caller
	 * @return CompleteableFuture that provides access to the String response from
	 *         the remote service implementation
	 */
	CompletableFuture<String> callasync(String from);

}