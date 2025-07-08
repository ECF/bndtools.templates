#ArithmeticTools Server Impl

This project provides an implementation of the Example ArithmeticTools service API.

The implementation of ArithmeticTools is in class [ArithmeticToolsComponent](src/main/java/$basePackageDir$/ArithmeticToolsComponent.java) in this project.

##Launching the Server

To launch this server from within Bndtools

1. Open the file [arithmetictools.server.bndrun](arithmetictools.server.bndrun) in the bndrun editor
2. Click on Resolve button on right and then Set Cache
3. Choose Run OSGi or Debug OSGi to launch the tools server

If run in debug mode, upon launch the console output will be similar to the following

```console
Jul 07, 2025 11:28:22 AM org.apache.aries.spifly.BaseActivator log
INFO: Registered provider org.slf4j.simple.SimpleServiceProvider of service org.slf4j.spi.SLF4JServiceProvider in bundle slf4j.simple
____________________________
Welcome to Apache Felix Gogo

g! 11:28:22.870;EXPORT_REGISTRATION;exportedSR=[myproject.api.ArithmeticTools];cID=StringID[ecftcp://LAPTOP-E2NLR1T7.domain:61160/server];rsId=1
--Endpoint Description---
<endpoint-descriptions xmlns="http://www.osgi.org/xmlns/rsa/v1.0.0">
  <endpoint-description>
    <property name="ecf.endpoint.id" value-type="String" value="ecftcp://localhost:61160/server"/>
    <property name="ecf.endpoint.id.ns" value-type="String" value="org.eclipse.ecf.core.identity.StringID"/>
    <property name="ecf.endpoint.ts" value-type="Long" value="1751912902843"/>
    <property name="ecf.rsvc.id" value-type="Long" value="1"/>
    <property name="endpoint.framework.uuid" value-type="String" value="e1de0f0c-2841-4e17-8236-403d4d818ab4"/>
    <property name="endpoint.id" value-type="String" value="a0a2bbb9-f0cd-4000-b267-ecb445f9da18"/>
    <property name="endpoint.package.version.myproject.api" value-type="String" value="1.0.0"/>
    <property name="endpoint.service.id" value-type="Long" value="17"/>
    <property name="objectClass" value-type="String">
      <array>
        <value>myproject.api.ArithmeticTools</value>
      </array>
    </property>
    <property name="osgi.ds.satisfying.condition.target" value-type="String" value="(osgi.condition.id=true)"/>
    <property name="remote.configs.supported" value-type="String">
      <array>
        <value>ecf.generic.server</value>
      </array>
    </property>
    <property name="remote.intents.supported" value-type="String">
      <array>
        <value>osgi.basic</value>
        <value>osgi.async</value>
        <value>osgi.private</value>
        <value>passByValue</value>
        <value>exactlyOnce</value>
        <value>ordered</value>
      </array>
    </property>
    <property name="service.imported" value-type="String" value="true"/>
    <property name="service.imported.configs" value-type="String">
      <array>
        <value>ecf.generic.server</value>
      </array>
    </property>
  </endpoint-description>
</endpoint-descriptions>
---End Endpoint Description
```
This output shows that the ArithmeticToolsComponent has been exported as a Remote Service endpoint description on localhost port 61160.  This example is using the ECF generic distribution provider.

This example also publishes this endpoint description for zeroconf LAN-based discovery using multicast IP so that it can be discovered and imported by the MCP Server and made available by the MCP Server to the MCP Client. 

Note that the Gogo OSGi Console is available and commands can be given to inspect the state of the server and the ArithmeticTools exported remote service.  For example

```
g! listexports
endpoint.id                          |Exporting Container ID                       |Exported Service Id
a0a2bbb9-f0cd-4000-b267-ecb445f9da18 |ecftcp://LAPTOP-E2NLR1T7.domain:61160/server |17

g! list
myproject.impl.ArithmeticToolsComponent in bundle 16 (myproject.impl:1.0.0.202507071809) enabled, 1 instance.
    Id: 0, State:ACTIVE
org.eclipse.ecf.internal.console.ContainerCommand in bundle 33 (org.eclipse.ecf.console:1.4.100.v20240808-1900) enabled, 1 instance.
    Id: 1, State:ACTIVE
org.eclipse.ecf.osgi.services.remoteserviceadmin.console.RSACommand in bundle 34 (org.eclipse.ecf.osgi.services.remoteserviceadmin.console:1.3.200.v20240808-1900) enabled, 1 instance.
    Id: 2, State:ACTIVE

```

##Next Steps

Two more projects need to be created to run the MCP Stdio Arithmetic Tools Client:

1. The MCP Server/ArithmeticTools Consumer.  Create the project via File->New->Bnd OSGi Project->MCP Server/ArithmeticTools Consumer project template.

2. The MCP ArithmeticTools Client. Create the project via File->New->Bnd OSGi Project->MCP ArithmeticTools Client project template.

Once both of these projects have been created, see the Readme.md in the MCP ArithmeticTools Client
to launch/run the MCP ArithmeticTools Client and Server.

#Communication Path for MCP Client call of ArithmeticTools Remote Service

The basic communication path involves 4 processes:

1.  ArithmeticToools Server Impl (this project):  Exports and publishes ArithmeticTools Remote Service
2.  MCP Server/ArithmeticTools Consumer:  Discovers and imports ArithmeticTools Remote Service Proxy.  Also runs MCP Server and adds tools imported to MCP Server Tools List.  See 
3.  MCP ArithmeticTools Client. Launches MCP Server (2) as separate process and uses stdio transport for MCP client -> MCP Server communication.

The communication path of an MCP client call of add 5 and 3 is as follows:

```
MCP Client (3)-> 
     Stdio -> 
          MCP Server/ArithmeticTools Consumer (2) ->
               Discovers and Imports ArithmeticTools Remote Service Proxy ->
                   ArithmeticTools Server (1) ->
                        Exports and Publishes Remote ArithmeticToolsComponent
                             Implements 'add' and 'multiply' tools
                        					
```
To have the above MCP call succeed, the ArithmeticTools Server (1) must be started before the MCP Tool Example Client/MCP Server (3,2) processes are launched.  

