package com.practice.designpatterns.structural.adapter.socialmediaaggregator;

public class SocialMediaPost {
    String id;
    String status;
    Long userId;
    Long timestamp;

    public SocialMediaPost(String id, String status, Long userId, Long timestamp) {
        this.id = id;
        this.status = status;
        this.userId = userId;
        this.timestamp = timestamp;
    }

    public SocialMediaPost(String id, String tweet, Long userId) {
        this.id = id;
        this.status = tweet;
        this.userId = userId;
    }
}
