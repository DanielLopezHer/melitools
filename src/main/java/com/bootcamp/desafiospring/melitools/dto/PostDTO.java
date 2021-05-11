package com.bootcamp.desafiospring.melitools.dto;

import com.bootcamp.desafiospring.melitools.entity.ProductEntity;
import com.bootcamp.desafiospring.melitools.utils.Constants;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDTO {
    private int userId;
    private int id_post;
    @JsonFormat(pattern = Constants.DATE_FORMAT, timezone = Constants.TIME_ZONE)
    private Date date;
    private ProductEntity detail;
    private int category;
    private double price;

    @Override
    public String toString() {
        return "PostDTO{" +
                "userId=" + userId +
                ", id_post=" + id_post +
                ", date=" + date +
                ", detail=" + detail +
                ", category=" + category +
                ", price=" + price +
                '}';
    }
}
