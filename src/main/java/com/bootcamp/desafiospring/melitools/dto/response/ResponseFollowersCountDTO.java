package com.bootcamp.desafiospring.melitools.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseFollowersCountDTO extends BaseResponseDTO {
    private int followers_count;

    public ResponseFollowersCountDTO(int userId, String userName, int followers_count) {
        super(userId, userName);
        this.followers_count = followers_count;
    }

    @Override
    public String toString() {
        return "ResponseFollowersCount{" +
                "followers_count=" + followers_count +
                '}';
    }
}
