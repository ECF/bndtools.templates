package $basePackageName$;

import org.osgi.service.component.annotations.Component;

import java.util.concurrent.TimeUnit;

import $api_package$.$serviceName$Request;
import $api_package$.$serviceName$Response;
import $api_package$.$serviceName$Service;
import $api_package$.Rx3$serviceName$Grpc;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;

@Component(property = {
		"service.exported.interfaces=*",
		"service.exported.configs=ecf.grpc.server",
		"ecf.grpc.server.port=50002"})
public class $serviceName$Impl extends Rx3$serviceName$Grpc.$serviceName$ImplBase implements $serviceName$Service {

	@Override
	public Single<$serviceName$Response> myUnaryCall(Single<$serviceName$Request> request) {
		return request.map(r -> {
			System.out.println("myUnaryCall received=" + r.getRequestMessage());
			return r;
		}).map(r -> createServiceResponse());
	}

	@Override
	public Flowable<$serviceName$Response> myServerStream(Single<$serviceName$Request> request) {
		return request.map(r -> {
			System.out.println("myServerStream received=" + r.getRequestMessage());
			return r;
		}).toFlowable().flatMap(r -> {
			// delay a short time between each of 30 responses
			return Flowable.fromArray(createServiceResponses(30)).delay(RESPONSE_DELAY, RESPONSE_DELAY_UNITS);
		}).map(r -> createServiceResponse());
	}

	@Override
	public Single<$serviceName$Response> myClientStream(Flowable<$serviceName$Request> requests) {
		return requests.map($serviceName$Request::getRequestMessage).map(m -> {
			System.out.println("myClientStream received="+m);
			return m;
		}).toList().map(names -> createServiceResponse());
	}

	@Override
	public Flowable<$serviceName$Response> myBidiStream(Flowable<$serviceName$Request> request) {
		return request.map(r -> {
			System.out.println("myBidiStream request received=" + r.getRequestMessage());
			return r;
		}).map(r -> createServiceResponse());
	}

	private static final int RESPONSE_DELAY = 500;
	private static final TimeUnit RESPONSE_DELAY_UNITS = TimeUnit.MILLISECONDS;
	
	private $serviceName$Response createServiceResponse() {
		return $serviceName$Response.newBuilder().setResponseMessage("OK").build();
	}

	private $serviceName$Response[] createServiceResponses(int count) {
		$serviceName$Response[] responses = new $serviceName$Response[count];
		for (int i = 0; i < count; i++) {
			responses[i] = createServiceResponse();
		}
		return responses;
	}

}