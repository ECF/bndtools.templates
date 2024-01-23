Readme for Sync API Project

This project results from using the Sync API project template to create a project.  This API project 
exposes a single interface (in src directory) that defines the service interface.  This interface is 
used by an impl project (that provides, exports, and publishes for discovery an implementation of this 
service interface) and a consumer project (with a consumer that can discover, import and use the service).

To export an implementation of this service, it's necessary to create another project with the Sync Impl
project template.   To import and use the service, you need to create a consumer project with the
Sync Consumer project template.   The impl and consumer project templates are both available from 
File->New->Bnd OSGi Project menu.