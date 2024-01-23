README for gRPC Remote Services Impl Project

Requirements:  Previously create in same workspace a project based upon the gRPC Remote Services API
project template.

This impl project has a class that implements the HealthCheckService Remote Service declared in the 
gRPC Remote Services API Project (should have been previously created as per requirements above).  

The way to run/start this project is the following:

1. Open the <projectname>.zeroconf.generic.bndrun file (or <projectname>.etcd3.generic.bndrun) with the bndtools 
bndrun editor.
2. Wait for the Repositories and the Run Requirements sections to be populated (can take a few seconds).
3. Under Run Requirements click on Resolve button.  After a few seconds a window will pop up when resolution is complete.
4. On the pop-up window, select the Update button.
5. Click on Run OSGi (or Debug OSGi) above and to the right of Run Requirements.  

This will start a running framework and output the following to a console window:
Jan 22, 2024 6:45:34 PM org.apache.aries.spifly.BaseActivator log
INFO: Registered provider io.grpc.protobuf.services.internal.HealthCheckingRoundRobinLoadBalancerProvider of service io.grpc.LoadBalancerProvider in bundle wrapped.io.grpc.grpc-services
Jan 22, 2024 6:45:34 PM org.apache.aries.spifly.BaseActivator log
INFO: Registered provider io.grpc.internal.PickFirstLoadBalancerProvider of service io.grpc.LoadBalancerProvider in bundle wrapped.io.grpc.grpc-core
Jan 22, 2024 6:45:34 PM org.apache.aries.spifly.BaseActivator log
INFO: Registered provider io.grpc.internal.DnsNameResolverProvider of service io.grpc.NameResolverProvider in bundle wrapped.io.grpc.grpc-core
Jan 22, 2024 6:45:34 PM org.apache.aries.spifly.BaseActivator log
INFO: Registered provider io.grpc.netty.NettyChannelProvider of service io.grpc.ManagedChannelProvider in bundle wrapped.io.grpc.grpc-netty
Jan 22, 2024 6:45:34 PM org.apache.aries.spifly.BaseActivator log
INFO: Registered provider io.grpc.netty.UdsNameResolverProvider of service io.grpc.NameResolverProvider in bundle wrapped.io.grpc.grpc-netty
Jan 22, 2024 6:45:34 PM org.apache.aries.spifly.BaseActivator log
INFO: Registered provider io.grpc.netty.NettyServerProvider of service io.grpc.ServerProvider in bundle wrapped.io.grpc.grpc-netty
____________________________
Welcome to Apache Felix Gogo

g! 18:45:34.732;EXPORT_REGISTRATION;exportedSR=[org.health.api.HealthCheckService];cID=URIID [uri=//localhost:50002];rsId=1
--Endpoint Description---
<endpoint-descriptions xmlns="http://www.osgi.org/xmlns/rsa/v1.0.0">
...the xml of the endpoint...
---End Endpoint Description---

The EXPORT_REGISTRATION means that the HealthCheckService has been exported and published for discovery
(using zeroconf or etcd) and is waiting for incoming requests from a consumer.

Note that if breakpoints are added to either the consumer and/or the impl project classes, and the Debug 
mode (Debug OSGi button) is used then breakpoints will be hit and the execution will stop at any breakpoints
added.  