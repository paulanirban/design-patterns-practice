package com.practice.designpatterns.structural.adapter.socialmediaaggregator.external;

import java.util.ArrayList;
import java.util.List;

import static com.practice.designpatterns.structural.adapter.socialmediaaggregator.external.ApiUtils.logFacebookGetPosts;
import static com.practice.designpatterns.structural.adapter.socialmediaaggregator.external.ApiUtils.logFacebookPostStatus;

public class FacebookApi {
    public List<FacebookPost> fetchFacebookPosts(Long userId, Long timestamp) {
        // Implementation to fetch Facebook posts
        logFacebookGetPosts();
        List<FacebookPost> fbPostLst = new ArrayList<>();
        fbPostLst.add(new FacebookPost("1", "Hello World", 1L, 123456789L));
        return fbPostLst;
    }

    public void postFacebookStatus(Long user, String status) {
        // Implementation to post a status on Facebook
        logFacebookPostStatus();
    }
}
