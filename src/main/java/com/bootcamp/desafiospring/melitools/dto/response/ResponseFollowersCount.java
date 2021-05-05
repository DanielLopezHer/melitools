package com.bootcamp.desafiospring.melitools.dto.response;

import org.springframework.http.HttpStatus;

public class ResponseFollowersCount extends Response{
    private int userId;
    private String userName;
    private int followers_count;

    public ResponseFollowersCount(String message, HttpStatus status, int userId, String userName, int followers_count) {
        super(message, status);
        this.userId = userId;
        this.userName = userName;
        this.followers_count = followers_count;
    }

    public ResponseFollowersCount(String message, HttpStatus status, int followers_count) {
        super(message, status);
        this.followers_count = followers_count;
    }

    public int getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(int followers_count) {
        this.followers_count = followers_count;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "ResponseFollowersCount{" +
                "followers_count=" + followers_count +
                '}';
    }
}
