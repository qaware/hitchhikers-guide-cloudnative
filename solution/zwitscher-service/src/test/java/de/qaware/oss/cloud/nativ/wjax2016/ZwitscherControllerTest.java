package de.qaware.oss.cloud.nativ.wjax2016;

import org.junit.Test;
import org.springframework.http.HttpEntity;

import java.util.Collection;

import static org.junit.Assert.assertFalse;

public class ZwitscherControllerTest {
    @Test
    public void tweets() throws Exception {
        ZwitscherController controller = new ZwitscherController();
        HttpEntity<Collection<String>> tweets = controller.tweets();
        assertFalse(tweets.getBody().isEmpty());
    }

}