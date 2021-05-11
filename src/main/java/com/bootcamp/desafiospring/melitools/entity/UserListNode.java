package com.bootcamp.desafiospring.melitools.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserListNode {
    private int userId;
    private String userName;

    @Override
    public String toString() {
        return "UserListNode{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
