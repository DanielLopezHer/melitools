package com.bootcamp.desafiospring.melitools.dto.response;

import org.springframework.http.HttpStatus;

public class ResponseFollowersCount extends BaseResponse {
    private int followers_count;


    public ResponseFollowersCount(int userId, String userName, int followers_count) {
        super(userId, userName);
        this.followers_count = followers_count;
    }

    public int getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(int followers_count) {
        this.followers_count = followers_count;
    }

    @Override
    public String toString() {
        return "ResponseFollowersCount{" +
                "followers_count=" + followers_count +
                '}';
    }
}
