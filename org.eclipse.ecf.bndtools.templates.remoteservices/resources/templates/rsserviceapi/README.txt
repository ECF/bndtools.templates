README for ECF Remote Services Sync API Project

This project results from using the Sync API project template.  This project declares 
a single class: a HelloService interface (in src directory).  The HelloService interface 
can be implemented by an impl project, which impls, exports, and publishes for discovery 
a simple implementation of the HelloService.   Once exported and published for discovery
by the impl project, a consumer project may then discover, import and call the HelloService. 

Impl Project to Export Remote Service

To export an implementation of this service, create another Bnd Project using the ECF 
Remote Services Sync Impl project template.  The ECF Remote Services Sync Impl project
template is available via the File->New->Bnd OSGi Project menu.

Consumer Project to Import and Use Remote Services

To import a proxy for the exported remote HelloService, create another Bnd Project using the ECF 
Remote Services Sync Consumer project template.  The ECF Remote Services Sync Consumer project
template is available via the File->New->Bnd OSGi Project menu.

