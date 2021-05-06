package com.bootcamp.desafiospring.melitools.repository.collections;

import com.bootcamp.desafiospring.melitools.entity.ProductEntity;

import java.util.HashMap;
import java.util.Map;

public class ProductsCollection {
    public static Map<Integer, ProductEntity> availableProducts = new HashMap<>();
}
