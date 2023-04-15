package $basePackageName$;

import org.osgi.service.component.annotations.ReferencePolicy;

import java.util.concurrent.TimeUnit;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import $api_package$.$serviceName$Request;
import $api_package$.$serviceName$Service;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;

@Component(immediate = true)
public class $serviceName$ServiceConsumer {

	@Reference(policy = ReferencePolicy.DYNAMIC)
	private volatile $serviceName$Service service;
	
	void activate() {
		// test myUnaryCall
		service.myUnaryCall(getSingle("myUnaryCall client message")).subscribe(resp -> {
			System.out.println("myUnaryCall response=" + resp.getResponseMessage());
		});
		// Test myServerStream: single request, multiple server responses
		service.myServerStream(getSingle("myServerStream client message")).subscribe(resp -> {
			System.out.println("myServerStream received=" + resp.getResponseMessage());
		});

		// Test myClientStream: multiple client requests, single server response
		service.myClientStream(getRequestFlowable(40, "myClientStream client message")).subscribe(resp -> {
			System.out.println("myClientStream response=" + resp.getResponseMessage());
		});

		// Test myBidiStream: multiple client requests, multiple server responses
		// Make flowable of 30 requests for watchClient
		service.myBidiStream(getRequestFlowable(30, "myBidiStream client message")).subscribe(resp -> {
			System.out.println("myBidiStream received=" + resp.getResponseMessage());
		});
	}
	
	private static final int RESPONSE_DELAY = 500;
	private static final TimeUnit RESPONSE_DELAY_UNITS = TimeUnit.MILLISECONDS;
	
	private Single<$serviceName$Request> getSingle(String message) {
		return Single.just($serviceName$Request.newBuilder().setRequestMessage(message).build());
	}

	private Flowable<$serviceName$Request> getRequestFlowable(int count, String message) {
		$serviceName$Request[] requests = new $serviceName$Request[count];
		for (int i = 0; i < count; i++) {
			requests[i] = $serviceName$Request.newBuilder().setRequestMessage(message + " #" + String.valueOf(i)).build();
		}
		return Flowable.fromArray(requests).delay(RESPONSE_DELAY,RESPONSE_DELAY_UNITS);
	}
}
