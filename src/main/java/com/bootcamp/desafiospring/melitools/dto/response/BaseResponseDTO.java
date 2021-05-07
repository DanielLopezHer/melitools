package com.bootcamp.desafiospring.melitools.dto.response;

public class BaseResponseDTO {
    private int userId;
    private String userName;

    public BaseResponseDTO() { }

    public BaseResponseDTO(int userId, String userName) {
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
        return "BaseResponse{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
