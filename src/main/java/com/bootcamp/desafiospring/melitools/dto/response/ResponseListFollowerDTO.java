package com.bootcamp.desafiospring.melitools.dto.response;

import com.bootcamp.desafiospring.melitools.entity.UserListNode;

import java.util.Arrays;

public class ResponseListFollowerDTO extends BaseResponseDTO {
    private UserListNode[] followers;

    public ResponseListFollowerDTO(int userId, String userName, UserListNode[] users) {
        super(userId, userName);
        this.followers = users;
    }

    public UserListNode[] getFollowers() {
        return followers;
    }

    public void setFollowers(UserListNode[] followers) {
        this.followers = followers;
    }

    @Override
    public String toString() {
        return "ResponseList{" +
                "users=" + Arrays.toString(followers) +
                '}';
    }
}
