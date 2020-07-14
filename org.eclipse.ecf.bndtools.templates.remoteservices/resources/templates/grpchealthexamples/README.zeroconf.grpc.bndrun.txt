Discovery Note:  The zeroconf discovery uses LAN-based multicast.  If multicast is disabled 
on the LAN, then discovery cannot happen.

To start the gRPC-based Health Example Service, open the &lt;projectName&gt;.zeroconf.grpc.server.bndrun 
file, goto the Run tab, click on the Resolve button under the Run Requirements section on the right
hand side, and when the resolve completes then click either the Run OSGi or Debug OSGi buttons
in the upper right of the Run tab.

Upon start, the grpc.server will export the Health Service, and the Endpoint Description will be
printed to the console and published via Zeroconf discovery.

After starting the grpc.server.bndrun, open the zeroconf.grpc.consumer.bndrun, again click Resolve
and then OSGi Run/Debug to start the consumer.

Once both are started, after a few seconds the remote service will be discovered via Zeroconf, and 
the exported remote Health service imported.  This will result in the remote service being injected
on the consumer, and then called.  

For the source code and docs for the grpc example health is available here:

https://github.com/ECF/Py4j-RemoteServicesProvider

