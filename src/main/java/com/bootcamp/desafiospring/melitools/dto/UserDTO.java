package com.bootcamp.desafiospring.melitools.dto;


import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private int userId;
    private String name;
    private String lastName;
    private List<Integer> followers;
    private List<Integer> followed;
    private List<Integer> posts;

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", followers=" + followers +
                ", followed=" + followed +
                ", posts=" + posts +
                '}';
    }
}
