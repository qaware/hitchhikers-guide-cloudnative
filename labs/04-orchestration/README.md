# Exercise 4: Orchestration

## Step 01: Writing a Marathon specification

To orchestrate our showcase we need to write the appropriate Marathon JSON specifications.
Implement the JSON specification for your Zwitscher service and include the following:

* Make sure to give your application a unique ID, such as `zwitscher-service-<username>`
* Start 1 instance, with 0.5 CPUs and 256 of memory
* Specify your Docker container using BRIDGE networking mode with required port mappings
* Define health checks for the `/admin/health` endpoint
* Define `zwitscher-consul` as a dependency for your application
* Declare the `CONSUL_HOST` env variable and set the value to the Mesos DNS name of the zwitscher-consul application

The resulting JSON file might look something like the following:

```json
{
  "id": "zwitscher-service-hitchhikersguide",

  "instances": 1,
  "cpus": 0.5,
  "mem": 256,

  "cmd": "java -Xmx128m -Dserver.port=$PORT0 -Dspring.cloud.consul.discovery.ip-address=$HOST -jar /app/zwitscher-service/zwitscher-service.jar",

  "container": {
    "type": "DOCKER",
    "docker": {
      "image": "hitchhikersguide/zwitscher-service:1.0.0",
      "network": "BRIDGE",
      "portMappings": [
        {
          "containerPort": 0,
          "hostPort": 0,
          "protocol": "tcp"
        }
      ]
    }
  },

  "healthChecks": [
    {
      "protocol": "HTTP",
      "path": "/admin/health",
      "intervalSeconds": 10,
      "portIndex": 0,
      "timeoutSeconds": 10,
      "maxConsecutiveFailures": 3
    }
  ],

  "dependencies": [
    "zwitscher-consul"
  ],

  "env": {
    "CONSUL_HOST": "zwitscher-consul.marathon.mesos"
  },

  "labels": {
    "LAUNCHPAD_COLOR": "LIGHT_GREEN",
    "LAUNCHPAD_ROW": "1"
  }
}
```

The tricky parts are the port mapping and passing the details used during the service registration.
To be able to scale the application easily the ports need to be assigned by DC/OS. The automatically assigned port is available via the `$PORT0` environment variable, which can then be used to set the `server.port` system property on startup. We also need to manually assign the external IP of the DC/OS node the service is running on, otherwise it would use the Docker internal IP instead which won't work.

The Marathon specifications for Consul and Traefik are already implemented. Make sure you study the
details of those two specs as well.


## Step 02: Deploy to DC/OS cluster



## References

* http://mesosphere.github.io/marathon/docs/
* https://mesosphere.github.io/marathon/docs/application-basics.html
* https://mesosphere.github.io/marathon/docs/native-docker.html
* https://mesosphere.github.io/marathon/docs/ports.html
* https://mesosphere.github.io/marathon/docs/health-checks.html
