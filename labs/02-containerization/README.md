# Exercise 2: Containerization

## Step 01: Writing a Dockerfile for our microservice

Next, we need to containerize our micro service application. For this we have to write a `Dockerfile`
with the required commands to package and run our application. 

* Create a file `Dockerfile` in the root directory of your workspace.
* Choose your Java base image wisely! Size does matter.
    * openjdk:8u102-jdk
    * openjdk:8u92-jdk-alpine
    * qaware-oss-docker-registry.bintray.io/base/centos7-jre8
    * qaware-oss-docker-registry.bintray.io/base/debian8-jre8
    * qaware-oss-docker-registry.bintray.io/base/alpine-k8s-ibmjava8
* Copy the executable JAR and configuration files to the Docker image.
* Defined required environment variables and expose ports.
* Define the start command for the micro service JAR.

Tip: the Spring Boot JAR file can be enhanced with a shell script and made executable. 
See http://docs.spring.io/spring-boot/docs/current/reference/html/deployment-install.html


## Step 02: Building and running the Docker image locally


## Step 03: Push image to remote Docker registry
