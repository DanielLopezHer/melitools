package com.bootcamp.desafiospring.melitools.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseResponseDTO {
    private int userId;
    private String userName;

    @Override
    public String toString() {
        return "BaseResponse{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
