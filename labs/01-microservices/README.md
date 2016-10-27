# Exercise 1: Microservices

## Step 01: Project Creation using Spring Initializr

First, we are going to create our Twitter microservice using the Spring Initializr.
For this go to the following URL: https://start.spring.io

* Select Gradle as build tool.
* Enter the Group ID and Artifact Name.
* Select the following dependencies:
  * Actuator
  * Hystrix
  * Twitter
  * Web

Switch to the full version of the wizard to further customize the project. When
done, press the `Download` button. Extract and copy the downloaded archive to
your workspace directory.

Now you can import the Gradle project into your IDE. You should also be able to
compile and run the project without any errors on the command line using:
```bash
$ ./gradlew bootRun
```
