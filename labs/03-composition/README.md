# Exercise 3: Composition

## Step 01: Enhance the Twitter service with Consul (Service Discovery)

In this step we will add basic Service Discovery capabilities using Consul so that our
Zwitscher microservices instances can be found and addressed. The following steps are
required to get things up and running:

* Start Consul in development mode as Docker container using the CLI or Gradle
* Add the Consul Discovery Starter dependency
* Enable the discovery client mechanism and configure the relevant properties
* Configure the management endpoints

Starting a Consul service via Docker should be straight forward after the last exercise.
Pull and run the Docker container in the background, make sure to expose port 8500.

```bash
$ docker pull consul
$ docker run -d --name zwitscher-consul -p 8500:8500 consul

$ docker stop zwitscher-consul
$ docker start zwitscher-consul
```

Alternatively, you can wrap these commands in a Gradle `exec` task, e.g. like

```groovy
task createConsul(type: Exec, group: 'application', description: 'Create Consul container') {
    commandLine 'docker', 'run', '-d', '--name', 'zwitscher-consul', '-p', '8500:8500', 'consul'
}
```

Next we will add the required Consul Discovery Starter dependency to the Gradle build file. Once
done, we need to add the `@EnableDiscoveryClient` annotation to our main application.

```groovy
dependencies {
    // ... the other dependencies ...
    compile 'org.springframework.cloud:spring-cloud-starter-consul-discovery'
}
```

Per default, this mechanism expects the Consul server to run on `localhost:8500`. Since we run the
server with Docker we need to change the Consul host to the external Docker IP address, e.g. `192.168.99.100`.
We also need to configure a unique instance ID used when registering with Consul. We will also register
a health check URL to be run at regular intervals with Consul. For this, we will use the `/health` endpoint
from the Actuator dependency. The final application properties might look something like the
following.

```
spring.application.name=zwitscher-service
info.name=Zwitscher Service (W-JAX 2016 Hitchhiker's Guide)

# all actuator endpoints are below /admin
management.context-path=/admin

# specify Consul host and port
spring.cloud.consul.host=192.168.99.100
spring.cloud.consul.port=8500

# assign a unique instance ID
spring.cloud.consul.discovery.instance-id=${spring.application.name}:${spring.application.instance_id:${random.value}}-hitchhikersguide

# register IP address and heartbeats
spring.cloud.consul.discovery.prefer-ip-address=true
spring.cloud.consul.discovery.heartbeat.enabled=true

# specify the health check path and interval
spring.cloud.consul.discovery.health-check-path=${management.context-path}/health
spring.cloud.consul.discovery.health-check-interval=5s
```

Please make sure you assign something unique to the `info.name` property, so include
your local username in here. Also replace the `hitchhikersguide` in the instance ID
property with your username. This will make sure all instances are unique across all
the tutorial participants.


## Step 02: Enhance the Twitter service with Consul (Configuration)


## Step 03: Add a Traeffic edge server


## Step 04: Write a Docker Compose file


## References

* https://hub.docker.com/_/consul/
* https://cloud.spring.io/spring-cloud-consul/
