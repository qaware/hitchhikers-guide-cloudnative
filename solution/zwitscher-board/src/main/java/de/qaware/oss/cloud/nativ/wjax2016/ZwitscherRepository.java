package de.qaware.oss.cloud.nativ.wjax2016;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * The ZwitscherRepository uses a load balanced RestTemplate to access the /tweets, the
 * actual invocation is wrapped into a Hystrix command.
 */
@Repository
@Slf4j
public class ZwitscherRepository {

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    @Value("${board.zwitscherUrl}")
    private String tweetsRibbonUrl;

    /**
     * Find the matching Zwitscher messages for the given query.
     *
     * @param q the query, max 500 chars long
     * @return the tweets, never NULL
     */
    @HystrixCommand(commandKey = "FindByQ", fallbackMethod = "none", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public Collection<String> findByQ(final @Length(max = 500) String q) {
        log.info("Get Zwitscher message from {} using q={}.", tweetsRibbonUrl, q);

        String[] tweets = restTemplate.getForObject(tweetsRibbonUrl, String[].class, q);
        return Arrays.asList(tweets);
    }

    /**
     * Fallback method called by Hystrix in case of error.
     *
     * @param q the query, not used actually
     * @return empty collection
     */
    @SuppressWarnings("unused")
    protected Collection<String> none(final String q) {
        log.warn("Using fallback for Zwitscher messages.");
        return Collections.singletonList("Could not contact zwitscher-service");
    }
}
