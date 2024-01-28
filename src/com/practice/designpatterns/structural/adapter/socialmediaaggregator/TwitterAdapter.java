package com.practice.designpatterns.structural.adapter.socialmediaaggregator;

import com.practice.designpatterns.structural.adapter.socialmediaaggregator.external.TwitterApi;
import com.practice.designpatterns.structural.adapter.socialmediaaggregator.external.TwitterTweet;

import java.util.ArrayList;
import java.util.List;

public class TwitterAdapter implements SocialMediaAdapter {
    TwitterApi api = new TwitterApi();

    @Override
    public List<SocialMediaPost> getPosts(Long userId, Long timestamp) {
        return transformTwitterTweets(this.api.getTweets(userId));
    }

    @Override
    public void post(Long userId, String message) {
        this.api.tweet(userId, message);
    }

    private List<SocialMediaPost> transformTwitterTweets(List<TwitterTweet> tweets) {
        List<SocialMediaPost> posts = new ArrayList<>();

        for(TwitterTweet tweet : tweets) {
            posts.add(new SocialMediaPost(tweet.getId(), tweet.getTweet(), tweet.getUserId()));
        }

        return posts;
    }
}
