README for gRPC Remote Services Consumer Project

Requirements:  Previously create in same workspace a project based upon the gRPC Remote Services API
project template AND a project based upon the gRPC Remote Services Impl project template AND starting 
(using bndrun file) the gRPC Remote Services Impl framework.  See README.txt in the Impl project for
instructions for starting the Impl framework.

The project has a class that consumes the HealthCheckService Remote Service once both the API and Impl
projects have been created, and the Impl project has been started.  

See the single class in this project defined in src/main/java/HealthServiceConsumer.java.

Once the Impl project has been started and the remote service exported, the way to run/start this 
consumer is the following:

1. Open the <projectname>.zeroconf.generic.bndrun file (or <projectname>.etcd3.generic.bndrun) with the bndtools 
bndrun editor.
2. Wait for the Repositories and the Run Requirements sections to be populated (can take a few seconds).
3. Under Run Requirements click on Resolve button.  After a few seconds a window will pop up when resolution is complete.
4. On the pop-up window, select the Update button.
5. Click on Run OSGi (or Debug OSGi) above and to the right of Run Requirements.  

This will start a running framework and output the following to a console window:
Jan 22, 2024 6:50:22 PM org.apache.aries.spifly.BaseActivator log
INFO: Registered provider io.grpc.protobuf.services.internal.HealthCheckingRoundRobinLoadBalancerProvider of service io.grpc.LoadBalancerProvider in bundle wrapped.io.grpc.grpc-services
Jan 22, 2024 6:50:22 PM org.apache.aries.spifly.BaseActivator log
INFO: Registered provider io.grpc.internal.PickFirstLoadBalancerProvider of service io.grpc.LoadBalancerProvider in bundle wrapped.io.grpc.grpc-core
Jan 22, 2024 6:50:22 PM org.apache.aries.spifly.BaseActivator log
INFO: Registered provider io.grpc.internal.DnsNameResolverProvider of service io.grpc.NameResolverProvider in bundle wrapped.io.grpc.grpc-core
Jan 22, 2024 6:50:22 PM org.apache.aries.spifly.BaseActivator log
INFO: Registered provider io.grpc.netty.NettyChannelProvider of service io.grpc.ManagedChannelProvider in bundle wrapped.io.grpc.grpc-netty
Jan 22, 2024 6:50:22 PM org.apache.aries.spifly.BaseActivator log
INFO: Registered provider io.grpc.netty.UdsNameResolverProvider of service io.grpc.NameResolverProvider in bundle wrapped.io.grpc.grpc-netty
Jan 22, 2024 6:50:22 PM org.apache.aries.spifly.BaseActivator log
INFO: Registered provider io.grpc.netty.NettyServerProvider of service io.grpc.ServerProvider in bundle wrapped.io.grpc.grpc-netty
____________________________
Welcome to Apache Felix Gogo

After a few seconds for discovery to occur (using zeroconf/multicast or etcd) the following will be printed
out

g! 18:50:28.567;IMPORT_REGISTRATION;importedSR=[org.health.api.HealthCheckService];cID=URIID [uri=//localhost:50002];rsId=1
--Endpoint Description---
<endpoint-descriptions xmlns="http://www.osgi.org/xmlns/rsa/v1.0.0">
...the xml of the endpoint...
---End Endpoint Description

The IMPORT_REGISTRATION means that the HealthCheckService has been discovered (using zeroconf or etcd) and 
imported successfully by the ECF gRPC distribution provider.  

At this point the HealthServiceConsumer classes activate method will be called by the service component
runtime, and as per the activate method (see HealthServiceConsumer.activate method implementation) the 
consumer will start communicating via the HealthCheckService service API to the remote service impl via
gRPC using the netty transport.  The output to the console looks like this:

check response=SERVING
watchBidi received=SERVING
watchServer received=SERVING
watchServer received=SERVING
watchServer received=SERVING
watchServer received=SERVING
watchServer received=SERVING
watchServer received=SERVING
watchServer received=SERVING
watchServer received=SERVING
watchServer received=SERVING
watchServer received=SERVING
watchServer received=SERVING
watchServer received=SERVING
watchServer received=SERVING
watchServer received=SERVING
watchServer received=SERVING
watchServer received=SERVING
watchServer received=SERVING
watchServer received=SERVING
watchServer received=SERVING
watchServer received=SERVING
watchServer received=SERVING
watchServer received=SERVING
watchServer received=SERVING
watchServer received=SERVING
watchServer received=SERVING
watchServer received=SERVING
watchServer received=SERVING
watchServer received=SERVING
watchServer received=SERVING
watchServer received=SERVING
watchBidi received=SERVING
watchBidi received=SERVING
watchBidi received=SERVING
watchBidi received=SERVING
watchBidi received=SERVING
watchBidi received=SERVING
watchBidi received=SERVING
watchBidi received=SERVING
watchBidi received=SERVING
watchBidi received=SERVING
watchBidi received=SERVING
watchBidi received=SERVING
watchBidi received=SERVING
watchBidi received=SERVING
watchBidi received=SERVING
watchBidi received=SERVING
watchBidi received=SERVING
watchBidi received=SERVING
watchBidi received=SERVING
watchBidi received=SERVING
watchBidi received=SERVING
watchBidi received=SERVING
watchBidi received=SERVING
watchBidi received=SERVING
watchBidi received=SERVING
watchBidi received=SERVING
watchBidi received=SERVING
watchBidi received=SERVING
watchBidi received=SERVING
watchClient response=SERVING

This output is a combination of calling the unary and streaming methods on the HealthCheckService, and the
response(s) from the remote service implementation.

Note that if breakpoints are added to either the consumer and/or the impl project classes, and the Debug 
mode (Debug OSGi button) is used then breakpoints will be hit and the execution will stop at any breakpoints
added.  
