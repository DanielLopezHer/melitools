package com.bootcamp.desafiospring.melitools.dto.response;

import com.bootcamp.desafiospring.melitools.entity.UserListNode;
import lombok.*;

import java.util.Arrays;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseListFollowedDTO extends BaseResponseDTO {
    private UserListNode[] followed;

    public ResponseListFollowedDTO(int userId, String userName, UserListNode[] users) {
        super(userId, userName);
        this.followed = users;
    }

    @Override
    public String toString() {
        return "ResponseList{" +
                "users=" + Arrays.toString(followed) +
                '}';
    }
}
