package de.qaware.oss.cloud.nativ.wjax2016;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;

/**
 * Basic Spring based REST controller for Zwitscher service.
 */
@RestController
@RequestMapping("/tweets")
public class ZwitscherController {
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public HttpEntity<Collection<String>> tweets() {
        return new ResponseEntity<>(Collections.singleton("Hello World."), HttpStatus.OK);
    }
}
