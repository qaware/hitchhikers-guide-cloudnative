package de.qaware.oss.cloud.nativ.wjax2016;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ZwitscherServiceApplicationTests.MockTwitterConfiguration.class)
@TestPropertySource("classpath:/application-test.properties")
public class ZwitscherServiceApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Configuration
    @Import(ZwitscherServiceApplication.class)
    public static class MockTwitterConfiguration {
        @Bean
        public Twitter twitter() {
            return Mockito.mock(Twitter.class);
        }
    }

}
