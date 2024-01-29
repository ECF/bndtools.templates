README for Sync Remote Service Impl Project

To run a framework to export the Sync Remote Service Impl

1. Open the <projectname>.zeroconf.generic.bndrun file (or <projectname>.etcd3.generic.bndrun) with 
the Bnd Run File Editor.
2. Wait for the Repositories and the Run Requirements sections to be populated (can take a few seconds).
3. Under Run Requirements click on the Resolve button.  After a few seconds a window will pop up 
when resolution is complete.
4. On the pop-up window, select the Update button.
5. Click on Run OSGi (or Debug OSGi) above and to the right of Run Requirements.  

This will start a running framework and output something like the following to a console window:

Welcome to Apache Felix Gogo

g! 15:47:28.816;EXPORT_REGISTRATION;exportedSR=[org.async.api.HelloSyncService];cID=StringID[ecftcp://LAPTOP-E2NLR1T7.domain:53773/server];rsId=1
--Endpoint Description---
<endpoint-descriptions xmlns="http://www.osgi.org/xmlns/rsa/v1.0.0">
...XML OF ENDPOINT DESCRIPITON FOR EXPORTED ENDPOINT...
---End Endpoint Description

The EXPORT_REGISTRATION means that the service has been exported by the ECF generic provider and 
a discovery publish message has been multicast to the LAN (or sent to etcd server if using etcd
for discovery).  This exported service can be then be, imported, and called by running a *consumer* 
bndrun config within an ECF Remote Services Sync Consumer project.  

Note that once a Run/Debug is started, there are ECF Remote Services commands defined that allow one to inspect 
the Remote Services Admin implementation, exported endpoints and endpoint descriptions, as well as 
the ability to dynamically export and import endpoints.  

To get a complete listing of the ECF RSA gogo commands type help at the gogo prompt and see the 
commands with the ecf scope:

g! help
ecf:exportservice
ecf:expsvc
ecf:importservice
ecf:impsvc
ecf:lcfgs
ecf:lcs
ecf:lctds
ecf:lexps
ecf:limps
ecf:listconfigs
ecf:listcontainers
ecf:listexports
ecf:listimports
ecf:listnamespaces
ecf:listtypedescriptions
ecf:lns
ecf:rsadebug
ecf:unexportservice
ecf:unexpsvc
ecf:unimportservice
ecf:unimpsvc
ecf:updateservice
ecf:updsvc
felix:bundlelevel
felix:cd
felix:frameworklevel
felix:headers
felix:help
felix:inspect
felix:install
felix:lb
felix:log
felix:ls
felix:refresh
felix:resolve
felix:start
felix:stop
felix:uninstall
felix:update
felix:which
gogo:cat
gogo:each
gogo:echo
gogo:format
gogo:getopt
gogo:gosh
gogo:grep
gogo:history
gogo:not
gogo:set
gogo:sh
gogo:source
gogo:tac
gogo:telnetd
gogo:type
gogo:until
scr:config
scr:disable
scr:enable
scr:info
scr:list

