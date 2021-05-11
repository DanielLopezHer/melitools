package com.bootcamp.desafiospring.melitools.dto.response;

import com.bootcamp.desafiospring.melitools.dto.PostDTO;
import lombok.*;

import java.util.Arrays;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseRecentPostsDTO extends BaseResponseDTO {
    private PostDTO[] recentPosts;

    @Override
    public String toString() {
        return "ResponseRecentPosts{" +
                "recentPosts=" + Arrays.toString(recentPosts) +
                '}';
    }
}
