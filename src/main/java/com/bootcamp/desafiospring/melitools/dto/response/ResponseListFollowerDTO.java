package com.bootcamp.desafiospring.melitools.dto.response;

import com.bootcamp.desafiospring.melitools.entity.UserListNode;
import lombok.*;

import java.util.Arrays;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseListFollowerDTO extends BaseResponseDTO {
    private UserListNode[] followers;

    public ResponseListFollowerDTO(int userId, String userName, UserListNode[] users) {
        super(userId, userName);
        this.followers = users;
    }

    @Override
    public String toString() {
        return "ResponseList{" +
                "users=" + Arrays.toString(followers) +
                '}';
    }
}
