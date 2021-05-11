package com.bootcamp.desafiospring.melitools.dto.response;

import com.bootcamp.desafiospring.melitools.entity.UserListNode;
import lombok.*;

import java.util.Arrays;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseListFollowedDTO extends BaseResponseDTO {
    private UserListNode[] followed;

    @Override
    public String toString() {
        return "ResponseList{" +
                "users=" + Arrays.toString(followed) +
                '}';
    }
}
