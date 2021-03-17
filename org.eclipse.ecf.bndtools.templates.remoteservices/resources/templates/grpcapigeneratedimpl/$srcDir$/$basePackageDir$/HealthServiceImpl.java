/*******************************************************************************
 * Copyright (c) 2020 Composent, Inc. and others. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Composent, Inc. - initial API and implementation
 ******************************************************************************/
package $basePackageName$;

import org.osgi.service.component.annotations.Component;

import $api_package$.HealthCheckRequest;
import $api_package$.HealthCheckResponse;
import $api_package$.HealthCheckResponse.ServingStatus;
import $api_package$.HealthCheckService;
import $api_package$.RxHealthCheckGrpc;
import io.reactivex.Single;

@Component(property = {
		"service.exported.interfaces=*",
		"service.exported.configs=ecf.grpc.server",
		"ecf.grpc.server.port=50002"})
public class HealthServiceImpl extends RxHealthCheckGrpc.HealthCheckImplBase implements HealthCheckService {

	@Override
	public Single<HealthCheckResponse> check(Single<HealthCheckRequest> request) {
		System.out.println("check request="+request);
		return Single.just(HealthCheckResponse.newBuilder().setStatus(ServingStatus.SERVING).build());
	}

}