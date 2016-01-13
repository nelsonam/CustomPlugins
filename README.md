# Alpine Custom Operator Framework

Customers can now create Custom Operators to integrate with Alpine. This opens up a new world of possibilities for data scientists and engineers to expand Alpine's functionality. 

- This framework allows data scientists and programmers to create a wide variety of Custom Operators to be used within an Alpine analytics workflow.
- The Custom Operators can consume one or more tabular datasets and may produce a tabular dataset as output to following operators. 
- Custom Operators can be written in either Java or Scala.
- The Custom Operator framework supports Spark and Database operators. 
- Once Custom Operators are deployed to an Alpine instance, the end user will not need to read, write or understand any code in order to use the new Custom Operator.
- Specifically, users can easily integrate with their own specific Spark jobs or run their own custom code against their data within the Alpine framework.  

As a result, an entire customer team can share pre-existing libraries of Analytics and have those incorporated into the Alpine visual workflows as simply another operator that can be chosen and configured through the Alpine drag and drop interface very quickly. 

To get started using Custom Operators, see the links below.

[How to Compile and Run the Sample Operators](https://alpine.atlassian.net/wiki/display/V5/How+To+Compile+and+Run+the+Sample+Operators)

[Building Your First Custom Operator in Scala](https://alpine.atlassian.net/wiki/display/V5/Building+Your+First+Custom+Operator+in+Scala)

[Building a Source Operator](https://alpine.atlassian.net/wiki/display/V5/Building+a+Source+Operator)

[Scala SDK Docs](http://alpinenow.github.io/PluginSDK/latest/api/#package)

## What Version Should I Use?

There are different versions of the Custom Operator Framework that map to different versions of the Alpine software. For more information, see the page here: [How to Update Custom Operators With New SDK Changes](https://alpine.atlassian.net/wiki/display/KB/How+to+Update+Custom+Operators+With+New+SDK+Changes)

Alpine Version | Custom Operator SDK Version | Spark Version
-------------- | --------------------------- | -------------
5.6.1          | 1.0                         | 1.3.1
5.7.1          | 1.3                         | 1.5.1
5.8            | 1.4.2                       | 1.5.1

