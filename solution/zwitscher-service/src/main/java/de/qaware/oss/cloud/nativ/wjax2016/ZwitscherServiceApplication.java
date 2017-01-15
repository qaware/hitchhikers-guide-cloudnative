package de.qaware.oss.cloud.nativ.wjax2016;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.social.TwitterAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {TwitterAutoConfiguration.class})
public class ZwitscherServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZwitscherServiceApplication.class, args);
    }
}
