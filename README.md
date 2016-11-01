<img src="https://raw.githubusercontent.com/qaware/hitchhikers-guide-cloudnative/master/logo.png" width="600px">

## Prerequisites
 * Notebook with at least 8 GB RAM
 * Windows 10, Mac OS X / macOS, Linux
 * Current Vagrant version installed (1.8.1 or later)
 * Current VirtualBox version installed (5.0.26 or later)
 * Current Docker Toolbox version installed (1.12.x or later)
 * Latest version of JDK 8
 * Latest version of IntelliJ (trial version is OK)
 * Keepass tool to access the [credentials](accounts.kdbx) used in the labs: [Win](http://keepass.info), [macOS](http://mstarke.github.io/MacPass), [Linux](http://keepass.info/help/v2/setup.html#mono)
 * (optional) Account for Docker Hub
 * Consider to attend our [Cloud Native Night Meetup](https://www.meetup.com/de-DE/cloud-native-muc/events/234936523/)

## Module 0: Introduction ([slides](slides/00-intro.pptx))

## Module 1: Microservices  ([slides](slides/01-microservices.pptx), [lab](labs/01-microservices))
### Theory
 * Introduction to Cloud Native and the available Cloud Native Stacks
 * Microservices - an architect's perspective: Ops components
 * Introduction to Spring Boot

### Practice
 * Setup training environment
 * Implementing a Spring Boot Twitter Microservice

## Module 2: Containerization  ([slides](slides/02-containerization.pptx), [lab](labs/02-containerization))
### Theory
 * Docker basics
 * Writing Dockerfiles

### Practice
 * Writing a Dockerfile for our Twitter Microservice
 * Building and running the image locally
 * Push image to Docker Registry

## Module 3: Composition  ([slides](slides/03-composition.pptx), [lab](labs/03-composition))
### Theory
 * Microservice blueprint: API Gateway, Service Discovery, Configuration, ...
 * Introduction to Docker Compose

### Practice
 * Enhance the Twitter Microservice with Consul (service discovery + configuration)
 * Enthance the Twitter Microservice with Traefik (edge server)
 * Write Docker Compose file

## Module 4: Orchestration  ([slides](slides/04-orchestration.pptx), [lab](labs/04-orchestration))
### Theory
 * Introduction and Overview DC/OS
 * Networking Basics
 * Persistent Storage Basics

### Practice
 * Writing Marathon specification
 * Deploy to DC/OS cluster with CLI (incl. setup CLI) and from Gradle
 
## Module 5: Explore  ([slides](slides/05-summary.pptx))
 * Sneak preview of other platforms like Kubernetes, OpenShift, Kontena and Gestalt
 * Play hard with the other platforms - how to get started

## License
<a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/"><img alt="Creative Commons Lizenzvertrag" style="border-width:0" src="https://i.creativecommons.org/l/by-sa/4.0/88x31.png" /></a><br /><span xmlns:dct="http://purl.org/dc/terms/" href="http://purl.org/dc/dcmitype/Text" property="dct:title" rel="dct:type">QAware Cloud Native Bootcamp</span> is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/">Creative Commons Attribution 4.0 International License</a>.
