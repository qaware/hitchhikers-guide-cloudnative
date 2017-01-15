package de.qaware.oss.cloud.nativ.wjax2016;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Repository;

import java.util.Collection;

import static java.util.stream.Collectors.toSet;

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
    public Collection<String> search(String q, int pageSize) {
        return null;
    }
}
