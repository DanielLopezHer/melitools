package com.bootcamp.desafiospring.melitools.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEntity {
    private int product_id;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;

    @Override
    public String toString() {
        return "ProductDTO{" +
                "product_id=" + product_id +
                ", productName='" + productName + '\'' +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
