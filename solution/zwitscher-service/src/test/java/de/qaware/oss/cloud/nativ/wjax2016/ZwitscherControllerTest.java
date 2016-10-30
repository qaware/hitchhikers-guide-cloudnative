package de.qaware.oss.cloud.nativ.wjax2016;

import org.junit.Test;
import org.springframework.http.HttpEntity;

import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ZwitscherControllerTest {

    @Test
    public void tweets() throws Exception {
        ZwitscherRepository repository = mock(ZwitscherRepository.class);
        ZwitscherController controller = new ZwitscherController(repository);
        controller.setQuery("cloudnativenerd");
        controller.setPageSize(42);

        when(repository.search("cloudnativenerd", 42)).thenReturn(Collections.singleton("Hello Test."));

        HttpEntity<Collection<String>> tweets = controller.tweets();
        assertFalse(tweets.getBody().isEmpty());
    }

}