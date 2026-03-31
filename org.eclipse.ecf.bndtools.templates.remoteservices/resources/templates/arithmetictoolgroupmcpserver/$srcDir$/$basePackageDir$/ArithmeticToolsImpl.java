package $basePackageName$;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import $api_package$.math.ArithmeticTools;

import reactor.core.publisher.Mono;

@Component(immediate = true)
public class ArithmeticToolsImpl implements ArithmeticTools {

	private static Logger logger = LoggerFactory.getLogger(ArithmeticToolsImpl.class);

	// This reference will be injected when the server has completed
	// activation. See SyncToolGroupServerImpl in package for lifecycle
	@Reference
	private SyncToolGroupServerImpl syncServer;
	// This reference will be injected when the server has completed
	// activation. See AsyncToolGroupServerImpl in package for lifecycle
	@Reference
	private AsyncToolGroupServerImpl asyncServer;

	@Activate
	void activate() {
		// addToolGroups will dynamically examine the McpTool 
		// and McpToolGroup annotations on the ArithmeticTools
		// interface class, implemented by this instance.
		syncServer.addToolGroups(this, ArithmeticTools.class);
		// Same for asynchronous tools (Mono return type below)
		asyncServer.addToolGroups(this, ArithmeticTools.class);
	}

	// The following methods implement ExampleToolGroup for the server
	@Override
	public double add(double x, double y) {
		logger.debug("Adding x={} y={}", x, y);
		return x + y;
	}

	@Override
	public double multiply(double x, double y) {
		logger.debug("Multiplying x={} y={}", x, y);
		return x * y;
	}

	@Override
	public Mono<Double> asyncAdd(double x, double y) {
		logger.debug("Async Adding x={} y={}", x, y);
		return Mono.just(add(x, y));
	}

	@Override
	public Mono<Double> asyncMultiply(double x, double y) {
		logger.debug("Async Multiplying x={} y={}", x, y);
		return Mono.just(multiply(x, y));
	}

}
