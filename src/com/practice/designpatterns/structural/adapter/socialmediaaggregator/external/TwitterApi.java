package com.practice.designpatterns.structural.adapter.socialmediaaggregator.external;

import java.util.ArrayList;
import java.util.List;

import static com.practice.designpatterns.structural.adapter.socialmediaaggregator.external.ApiUtils.logTwitterGetPosts;
import static com.practice.designpatterns.structural.adapter.socialmediaaggregator.external.ApiUtils.logTwitterPostStatus;

public class TwitterApi {
    public List<TwitterTweet> getTweets(Long userId) {
        // Implementation to fetch Twitter tweets
        logTwitterGetPosts();
        List<TwitterTweet> twLst = new ArrayList<>();
        twLst.add(new TwitterTweet("1", "Hello World", 1L));
        return twLst;
    }

    public void tweet(Long userId, String text) {
        // Implementation to send a tweet on Twitter
        logTwitterPostStatus();
    }
}
