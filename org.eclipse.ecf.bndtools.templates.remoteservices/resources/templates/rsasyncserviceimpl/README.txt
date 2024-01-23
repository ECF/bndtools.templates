README for Async Remote Service Impl Project

To start this project

1. Open the <projectname>.zeroconf.generic.bndrun file (or <projectname>.etcd3.generic.bndrun) with the bndtools 
bndrun editor.
2. Wait for the Repositories and the Run Requirements sections to be populated (can take a few seconds).
3. Under Run Requirements click on Resolve button.  After a few seconds a window will pop up when resolution is complete.
4. On the pop-up window, select the Update button.
5. Click on Run OSGi (or Debug OSGi) above and to the right of Run Requirements.  

This will start a running framework and output the following to a console window:

Welcome to Apache Felix Gogo

g! 15:47:28.816;EXPORT_REGISTRATION;exportedSR=[org.async.api.HelloAsyncService];cID=StringID[ecftcp://LAPTOP-E2NLR1T7.domain:53773/server];rsId=1
--Endpoint Description---
<endpoint-descriptions xmlns="http://www.osgi.org/xmlns/rsa/v1.0.0">
...the xml of the endpoint...
---End Endpoint Description

The EXPORT_REGISTRATION means that the HelloAsyncService has been exported by the ECF generic provider and 
a discovery publish message (using either zeroconf/multicast or etcd based upon discovery mechanism used) has been 
sent.  This exported service can be then be discovered, imported, and called by running a *consumer* bndrun framework.
There is also a Async Consumer project template that can be used to create a consumer.

Note that if the impl is run via Debug OSGi (debug mode), then when the consumer actually calls the remote
hello method, the debugger will stop inside the hello method impl if a breakpoint is added to the hello impl
method.
