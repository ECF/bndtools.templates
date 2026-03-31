#MCP ToolGroups Example API project

This project has a simple MCP [ArithmeticTools](src/main/java/$basePackageDir$/math/ArithmeticTools.java) service interface.

The ArithmeticTools methods are annotated with the @McpTool annotations. 

In this example API project, the @McpToolGroup annotation is used to
annotate the [ArithmeticTools class](src/$basePackageDir$/math/ArithmeticTools.java) as well as it's parent package defined in the $basePackageName$/package-info.java). 

These two McpToolGroup annotations defines a simple
two-level group hierarchy, with the parent package defining the root group, and the ArithmeticTools class defining a sub-group for the McpTool-annotated ArithmeticTools methods.

##Next Steps: 

###Create a MCP ToolGroups Example Server Project

Choose File->New->Bnd OSGi Project->MCP ToolGroups Example Servers project.  

Complete the project creation wizard to create a new project in workspace.

See the Readme.md in the new example servers project for instructions on launching.

