package com.bootcamp.desafiospring.melitools.dto.response;

import com.bootcamp.desafiospring.melitools.entity.UserListNode;

import java.util.Arrays;

public class ResponseListFollowed extends BaseResponse{
    private UserListNode[] followed;

    public ResponseListFollowed(int userId, String userName, UserListNode[] users) {
        super(userId, userName);
        this.followed = users;
    }

    public UserListNode[] getFollowed() {
        return followed;
    }

    public void setFollowed(UserListNode[] followed) {
        this.followed = followed;
    }

    @Override
    public String toString() {
        return "ResponseList{" +
                "users=" + Arrays.toString(followed) +
                '}';
    }
}
