package com.bootcamp.desafiospring.melitools.repository.collections;

import com.bootcamp.desafiospring.melitools.dto.PostDTO;

import java.util.HashMap;
import java.util.Map;

public class PostsCollection {
    public static Map<Integer, PostDTO> availablePosts = new HashMap<>();
}
