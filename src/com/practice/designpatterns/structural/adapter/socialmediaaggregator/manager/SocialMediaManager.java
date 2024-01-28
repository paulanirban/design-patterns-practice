package com.practice.designpatterns.structural.adapter.socialmediaaggregator.manager;

import com.practice.designpatterns.structural.adapter.socialmediaaggregator.external.FacebookApi;
import com.practice.designpatterns.structural.adapter.socialmediaaggregator.external.FacebookPost;
import com.practice.designpatterns.structural.adapter.socialmediaaggregator.external.TwitterApi;
import com.practice.designpatterns.structural.adapter.socialmediaaggregator.external.TwitterTweet;

import java.util.List;

public class SocialMediaManager {
    private FacebookApi facebookApi = new FacebookApi();
    private TwitterApi twitterApi = new TwitterApi();

    public void getMessages(Long userId, Long timestamp, String platform) {
        if (platform.equals("facebook")) {
            List<FacebookPost> posts = facebookApi.fetchFacebookPosts(userId, timestamp);
        } else if (platform.equals("twitter")) {
            List<TwitterTweet> tweets = twitterApi.getTweets(userId);
        }
    }
}
