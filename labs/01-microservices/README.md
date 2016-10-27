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

## Step 02: Implement Zwitscher REST Endpoint

Next we implement a basic Spring based REST endpoint to return a list of Tweets upon a simple
`GET /tweets` request. For now simply return a dummy string. As a bonus, implement a simple
JUnit test to check for the correct behaviour.

```java
@RestController
@RequestMapping("/tweets")
public class ZwitscherController {
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public HttpEntity<Collection<String>> tweets() {
        return new ResponseEntity<>(Collections.singleton("Hello World."), HttpStatus.OK);
    }
}
```
