README for JaxRS Impl Project

Requirements:  Previously create in same workspace a project based upon the JaxRS API project template.

To start this project

1. Open the <projectname>.zeroconf.generic.bndrun file (or <projectname>.etcd3.generic.bndrun) with the bndtools 
bndrun editor.
2. Wait for the Repositories and the Run Requirements sections to be populated (can take a few seconds).
3. Under Run Requirements click on Resolve button.  After a few seconds a window will pop up when resolution is complete.
4. On the pop-up window, select the Update button.
5. Click on Run OSGi (or Debug OSGi) above and to the right of Run Requirements.  

This will start a running framework and output the following to a console window:

Welcome to Apache Felix Gogo

g! Jan 22, 2024 7:17:32 PM org.apache.aries.spifly.BaseActivator log
INFO: Registered provider org.eclipse.jetty.http.Http1FieldPreEncoder of service org.eclipse.jetty.http.HttpFieldPreEncoder in bundle org.apache.felix.http.jetty
Jan 22, 2024 7:17:32 PM org.apache.aries.spifly.BaseActivator log
INFO: Registered provider org.eclipse.jetty.http2.hpack.HpackFieldPreEncoder of service org.eclipse.jetty.http.HttpFieldPreEncoder in bundle org.apache.felix.http.jetty
SLF4J: No SLF4J providers were found.
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See https://www.slf4j.org/codes.html#noProviders for further details.
Jan 22, 2024 7:17:33 PM org.glassfish.jersey.internal.inject.Providers checkProviderRuntime
WARNING: A provider org.jaxrs.impl.HelloWorldResource registered in SERVER runtime does not implement any provider interfaces applicable in the SERVER runtime. Due to constraint configuration problems the provider org.jaxrs.impl.HelloWorldResource will be ignored. 
19:17:33.383;EXPORT_REGISTRATION;exportedSR=[org.jaxrs.api.HelloWorldService];cID=URIID [uri=http://localhost:8181/rs];rsId=1
--Endpoint Description---
<endpoint-descriptions xmlns="http://www.osgi.org/xmlns/rsa/v1.0.0">...the xml of the endpoint...
---End Endpoint Description

The EXPORT_REGISTRATION means that the HelloWorldResource has been exported by the JaxRS distribution provider and 
a discovery publish message (using either zeroconf/multicast or etcd based upon discovery mechanism used) has been 
sent.  This exported service can be then be discovered, imported, and called by running a *consumer* bndrun framework.
There is also a JaxRS Consumer project template that can be used to create a consumer for this remote service.

Note that if the impl is run via Debug OSGi (debug mode), then when the consumer actually calls the remote
method, the debugger will stop inside the method impl if a breakpoint has been added.