package de.qaware.oss.cloud.nativ.wjax2016;

import java.util.Collection;

/**
 * The ZwitscherRepository defines method to search for Tweets.
 */
public interface ZwitscherRepository {
    /**
     * Find and return the Tweets matching the given query.
     *
     * @param q        the query string up to 500 characters
     * @param pageSize the number of messages to return
     * @return a collection of messages
     */
    Collection<String> search(String q, int pageSize);
}
