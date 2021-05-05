package com.bootcamp.desafiospring.melitools.entity;

public class UserListNode {
    private int userId;
    private String userName;

    public UserListNode() { }

    public UserListNode(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
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
        return "UserListNode{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
