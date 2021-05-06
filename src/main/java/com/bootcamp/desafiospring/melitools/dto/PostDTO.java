package com.bootcamp.desafiospring.melitools.dto;

import com.bootcamp.desafiospring.melitools.entity.ProductEntity;
import com.bootcamp.desafiospring.melitools.utils.Constants;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PostDTO {
    private int userId;
    private int id_post;
    @JsonFormat(pattern = Constants.DATE_FORMAT, timezone = Constants.TIME_ZONE)
    private Date date;
    private ProductEntity detail;
    private int category;
    private double price;

    public PostDTO() { }

    public PostDTO(int userId, int id_post, Date date, ProductEntity detail, int category, double price) {
        this.userId = userId;
        this.id_post = id_post;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ProductEntity getDetail() {
        return detail;
    }

    public void setDetail(ProductEntity detail) {
        this.detail = detail;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

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
