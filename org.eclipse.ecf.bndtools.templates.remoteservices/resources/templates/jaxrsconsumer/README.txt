Readme for JaxRS Consumer Project

Requirements:  Previously create in same workspace a project based upon the gRPC Remote Services API
project template AND a project based upon the JaxRS Impl project template AND starting 
(using bndrun file) the JaxRS Impl framework.  See README.txt in the Impl project in your workspace for
instructions for starting the Impl framework.

The project has a class that consumes the HelloWorldService remote service once both the API and Impl
projects have been created, and the Impl project has been started.  

See the single class in this project defined in src/main/java/HelloWorldServiceConsumer.java.

Once the Impl project has been started and the remote service exported, the way to run/start this 
consumer is the following:

1. Open the <projectname>.zeroconf.generic.bndrun file (or <projectname>.etcd3.generic.bndrun) with the bndtools 
bndrun editor.
2. Wait for the Repositories and the Run Requirements sections to be populated (can take a few seconds).
3. Under Run Requirements click on Resolve button.  After a few seconds a window will pop up when resolution is complete.
4. On the pop-up window, select the Update button.
5. Click on Run OSGi (or Debug OSGi) above and to the right of Run Requirements.  

This will start a running framework and output the following to a console window:

This project results from using the JaxRS Consumer project template to create a project.  This consumer project 
has a single class 

To export an implementation of this service, it's necessary to create another project with the JaxRS Impl
project template.   To import and use the service, you need to create a consumer project with the
JaxRS Consumer project template.   The impl and consumer project templates are both available from 
File->New->Bnd OSGi Project menu.