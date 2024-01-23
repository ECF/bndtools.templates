README for Async Remote Service Consumer Project

To start this project

1. Open the <projectname>.zeroconf.generic.bndrun file (or <projectname>.etcd3.generic.bndrun) with the bndtools 
bndrun editor.
2. Wait for the Repositories and the Run Requirements sections to be populated (can take a few seconds).
3. Under Run Requirements click on Resolve button.  After a few seconds a window will pop up when resolution is complete.
4. On the pop-up window, select the Update button.
5. Click on Run OSGi (or Debug OSGi) above and to the right of Run Requirements.  

This will start a running framework and output the following to a console window:
____________________________
Welcome to Apache Felix Gogo

g! 16:03:33.468;IMPORT_REGISTRATION;importedSR=[org.async.api.HelloAsyncService];cID=StringID[ecftcp://LAPTOP-E2NLR1T7.domain:53773/server];rsId=1
--Endpoint Description---
<endpoint-descriptions xmlns="http://www.osgi.org/xmlns/rsa/v1.0.0">
...the xml of the endpoint...
---End Endpoint Description

The IMPORT_REGISTRATION means that the HelloAsyncService has been discovered (using zeroconf or etcd) and 
imported by the ECF generic provider.  This imported service can be then be used in the gogo console 
prompt like this:

g! helloasync MYNAME
g! HelloAsyncService responds: Hello Async To MYNAME

This means that the consumer has called the remote service impl's hello method (running in a separate framework
process), gotten a response, and then the response is printed out.

When the helloasync command is given in the gogo shell, it will result in calling the consumer's 
callasync method (see the class in this project).  If run in Debug mode (Debug OSGi) and if a 
breakpoint/breakpoints are added to callasync method, then the debugger will stop inside the 
callasync method.


