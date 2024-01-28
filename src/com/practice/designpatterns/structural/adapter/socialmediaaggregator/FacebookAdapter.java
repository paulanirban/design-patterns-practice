package com.practice.designpatterns.structural.adapter.socialmediaaggregator;

import com.practice.designpatterns.structural.adapter.socialmediaaggregator.external.FacebookApi;
import com.practice.designpatterns.structural.adapter.socialmediaaggregator.external.FacebookPost;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FacebookAdapter implements SocialMediaAdapter {
    FacebookApi api = new FacebookApi();

    @Override
    public List<SocialMediaPost> getPosts(Long userId, Long timestamp) {
        //return transformFacebookPosts(this.api.fetchFacebookPosts(userId, timestamp));
        return this.api.fetchFacebookPosts(userId, timestamp).stream().map(FacebookAdapter::to).collect(Collectors.toList());
    }

    private static SocialMediaPost to(FacebookPost post) {
        return new SocialMediaPost(post.getId(), post.getStatus(), post.getUserId(), post.getTimestamp());
    }

    @Override
    public void post(Long userId, String message) {
        this.api.postFacebookStatus(userId, message);
    }

    private List<SocialMediaPost> transformFacebookPosts(List<FacebookPost> fbPosts) {
        List<SocialMediaPost> posts = new ArrayList<>();

        for(FacebookPost post : fbPosts) {
            posts.add(new SocialMediaPost(post.getId(), post.getStatus(), post.getUserId(), post.getTimestamp()));
        }

        return posts;
    }
}
