package de.qaware.oss.cloud.nativ.wjax2016;

import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import io.prometheus.client.spring.boot.EnableSpringBootMetricsCollector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClientHttpRequestFactory;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnablePrometheusEndpoint
@EnableSpringBootMetricsCollector
@EnableFeignClients
@RibbonClient(name = "zwitscher-service")
public class ZwitscherBoardApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZwitscherBoardApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate zwitscherServiceRestTemplate(SpringClientFactory clientFactory) {
        RibbonClientHttpRequestFactory requestFactory = new RibbonClientHttpRequestFactory(clientFactory);
        return new RestTemplate(requestFactory);
    }
}
