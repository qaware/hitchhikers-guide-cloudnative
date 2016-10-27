package de.qaware.oss.cloud.nativ.wjax2016;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;

import static java.util.stream.Collectors.toList;

/**
 * Default implementation of our repository to search Twitter for tweets.
 */
@Repository
public class ZwitscherRepositoryImpl implements ZwitscherRepository {

    private final Twitter twitter;

    @Autowired
    public ZwitscherRepositoryImpl(Twitter twitter) {
        this.twitter = twitter;
    }

    @Override
    @HystrixCommand(fallbackMethod = "noResults")
    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    public Collection<String> search(String q, int pageSize) {
        // search and map results
        SearchResults results = twitter.searchOperations().search(q, pageSize);
        return results.getTweets().stream()
                .map(Tweet::getUnmodifiedText)
                .collect(toList());
    }

    @SuppressWarnings("unused")
    protected Collection<String> noResults(String q, int pageSize) {
        return Collections.singleton("Error getting tweets stream, using fallback.");
    }
}
