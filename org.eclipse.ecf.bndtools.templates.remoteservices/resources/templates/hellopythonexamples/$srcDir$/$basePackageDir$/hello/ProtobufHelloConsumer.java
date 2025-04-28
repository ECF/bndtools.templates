package $basePackageName$.hello;

import java.util.concurrent.CompletionStage;

import org.eclipse.ecf.examples.protobuf.hello.Hellomsg.HelloMsgContent;
import org.eclipse.ecf.examples.protobuf.hello.IHello;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.util.promise.Promise;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Component(immediate = true )
/**
 * Example consumer of IHello remote service (implemented in Python).
 */
public class ProtobufHelloConsumer {

	private static final Logger logger = LoggerFactory.getLogger(ProtobufHelloConsumer.class);
	
	private IHello helloservice;
	
	@Reference(target="(service.imported=*)", policy = ReferencePolicy.DYNAMIC)
	void bindHello(IHello hello) {
		logger.debug("proxy=" + String.valueOf(hello));
		this.helloservice = hello;
	}
	
	void unbindHello(IHello hello) {
		logger.debug("proxy=" + String.valueOf(hello));
		this.helloservice = null;
	}
	
	static HelloMsgContent createRequestMessage() {
		HelloMsgContent.Builder b1 = HelloMsgContent.newBuilder();
		b1.addX(1.1);
		b1.addX(1.2);
		b1.setF("java");
		b1.setTo("python");
		b1.setHellomsg("Hello from java");
		b1.setH("some other message");
		return b1.build();
	}
	
	@Activate
	void activate() throws Exception {
		// Call remote sayHello method.  This will block until a result is provided,
		// or until the value of osgi.basic.timeout value has expired (set by Python implementation)
		HelloMsgContent result = this.helloservice.sayHello(createRequestMessage());
		logger.debug("protobuf.sayHello result=" + result);
		
		// Call remote sayHelloAsync method
		CompletionStage<HelloMsgContent> cf = this.helloservice.sayHelloAsync(createRequestMessage());
		cf.whenComplete((resp,except) -> {
			if (except != null)
				logger.error("protubuf.sayHelloAsync resp=" + String.valueOf(resp), except);
			else
				logger.debug("protobuf.sayHelloAsync result="+resp);
		});
		// Call remote sayHelloPromise implementation
		Promise<HelloMsgContent> promise = this.helloservice.sayHelloPromise(createRequestMessage());
		promise.onResolve(() -> {
			try {
				logger.debug("protobuf.sayHelloPromise result=" + promise.getValue());
			} catch (Exception e) {
				logger.error("protobuf.sayHelloPromise failed", e);
			}
		});
	}

}
