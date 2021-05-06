package com.bootcamp.desafiospring.melitools.repository;

import com.bootcamp.desafiospring.melitools.dto.PostDTO;
import com.bootcamp.desafiospring.melitools.dto.UserDTO;
import com.bootcamp.desafiospring.melitools.entity.ProductEntity;
import com.bootcamp.desafiospring.melitools.exception.UserNotFoundException;

import java.io.IOException;
import java.util.List;

public interface MeliToolsRepositoryInterface {
    UserDTO searchUser(int userId) throws UserNotFoundException;
    boolean updateUsers() throws IOException;
    boolean searchPostId(int id);
    boolean searchProductId(int id);
    boolean registerProduct(ProductEntity product) throws IOException;
    boolean registerPost(PostDTO post) throws IOException;
    List<PostDTO> searchUsersRecentPosts(int userId) throws UserNotFoundException;

}
