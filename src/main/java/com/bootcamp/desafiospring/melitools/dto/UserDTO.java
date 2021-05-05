package com.bootcamp.desafiospring.melitools.dto;


import java.util.List;

public class UserDTO {
    private int userId;
    private String name;
    private String lastName;
    private List<Integer> followers;
    private List<Integer> followed;
    private List<Integer> posts;
    private List<Integer> specialPosts;

    public UserDTO() { }

    public UserDTO(int userId, String name, String lastName) {
        this.userId = userId;
        this.name = name;
        this.lastName = lastName;
    }

    public UserDTO(int userId, String name, String lastName, List<Integer> followers, List<Integer> followed, List<Integer> posts,
                   List<Integer> specialPosts) {
        this.userId = userId;
        this.name = name;
        this.lastName = lastName;
        this.followers = followers;
        this.followed = followed;
        this.posts = posts;
        this.specialPosts = specialPosts;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Integer> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Integer> followers) {
        this.followers = followers;
    }

    public List<Integer> getFollowed() {
        return followed;
    }

    public void setFollowed(List<Integer> followed) {
        this.followed = followed;
    }

    public List<Integer> getPosts() {
        return posts;
    }

    public void setPosts(List<Integer> posts) {
        this.posts = posts;
    }

    public List<Integer> getSpecialPosts() {
        return specialPosts;
    }

    public void setSpecialPosts(List<Integer> specialPosts) {
        this.specialPosts = specialPosts;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", followers=" + followers +
                ", followed=" + followed +
                ", posts=" + posts +
                ", specialPosts=" + specialPosts +
                '}';
    }
}
