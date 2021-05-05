package com.bootcamp.desafiospring.melitools.dto.response;

import com.bootcamp.desafiospring.melitools.entity.UserListNode;

import java.util.Arrays;

public class ResponseList extends BaseResponse{
    private UserListNode[] users;

    public ResponseList(int userId, String userName, UserListNode[] users) {
        super(userId, userName);
        this.users = users;
    }

    public UserListNode[] getUsers() {
        return users;
    }

    public void setUsers(UserListNode[] users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "ResponseList{" +
                "users=" + Arrays.toString(users) +
                '}';
    }
}
