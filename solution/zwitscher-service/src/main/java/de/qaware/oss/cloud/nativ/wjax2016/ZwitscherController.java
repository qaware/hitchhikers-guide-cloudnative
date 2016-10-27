package de.qaware.oss.cloud.nativ.wjax2016;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Basic Spring based REST controller for Zwitscher service.
 */
@RestController
@RequestMapping("/tweets")
public class ZwitscherController {

    private final ZwitscherRepository repository;

    @Autowired
    public ZwitscherController(ZwitscherRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public HttpEntity<Collection<String>> tweets() {
        Collection<String> tweets = repository.search("cloudnativenerd", 23);
        return new ResponseEntity<>(tweets, HttpStatus.OK);
    }
}
