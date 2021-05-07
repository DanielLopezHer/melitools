package com.bootcamp.desafiospring.melitools.dto.response;

import com.bootcamp.desafiospring.melitools.dto.PostDTO;

import java.util.Arrays;

public class ResponseRecentPostsDTO extends BaseResponseDTO {
    private PostDTO[] recentPosts;

    public ResponseRecentPostsDTO() { }

    public ResponseRecentPostsDTO(int userId, String userName, PostDTO[] recentPosts) {
        super(userId, userName);
        this.recentPosts = recentPosts;
    }

    public PostDTO[] getRecentPosts() {
        return recentPosts;
    }

    public void setRecentPosts(PostDTO[] recentPosts) {
        this.recentPosts = recentPosts;
    }

    @Override
    public String toString() {
        return "ResponseRecentPosts{" +
                "recentPosts=" + Arrays.toString(recentPosts) +
                '}';
    }
}
