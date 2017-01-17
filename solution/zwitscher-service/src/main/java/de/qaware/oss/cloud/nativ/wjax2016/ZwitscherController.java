package de.qaware.oss.cloud.nativ.wjax2016;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static java.util.Optional.ofNullable;

/**
 * Basic Spring based REST controller for Zwitscher service.
 */
@RestController
@RequestMapping("/tweets")
@RefreshScope
public class ZwitscherController {

    private final ZwitscherRepository repository;

    private String query;
    private int pageSize;

    @Autowired
    public ZwitscherController(ZwitscherRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public HttpEntity<Collection<String>> tweets(@RequestParam(value = "q", required = false) String q) {
        Collection<String> tweets = repository.search(ofNullable(q).orElse(query), pageSize);
        return new ResponseEntity<>(tweets, HttpStatus.OK);
    }

    @Value("${tweet.query:cloudnativenerd}")
    public void setQuery(String query) {
        this.query = query;
    }

    @Value("${tweet.pageSize:42}")
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
