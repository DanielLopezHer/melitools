package com.bootcamp.desafiospring.melitools.dto.response;

import com.bootcamp.desafiospring.melitools.dto.PostDTO;
import lombok.*;

import java.util.Arrays;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseRecentPostsDTO extends BaseResponseDTO {
    private PostDTO[] recentPosts;

    public ResponseRecentPostsDTO(int userId, String userName, PostDTO[] recentPosts) {
        super(userId, userName);
        this.recentPosts = recentPosts;
    }

    @Override
    public String toString() {
        return "ResponseRecentPosts{" +
                "recentPosts=" + Arrays.toString(recentPosts) +
                '}';
    }
}
