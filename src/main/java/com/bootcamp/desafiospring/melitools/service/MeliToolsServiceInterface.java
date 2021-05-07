package com.bootcamp.desafiospring.melitools.service;

import com.bootcamp.desafiospring.melitools.dto.PostDTO;
import com.bootcamp.desafiospring.melitools.dto.response.*;
import com.bootcamp.desafiospring.melitools.exception.DateNotValidException;
import com.bootcamp.desafiospring.melitools.exception.PostIdAlreadyAssignedException;
import com.bootcamp.desafiospring.melitools.exception.UserAlreadyFollowedException;
import com.bootcamp.desafiospring.melitools.exception.UserNotFoundException;

import java.io.IOException;

public interface MeliToolsServiceInterface {
    ResponseSimpleDTO followUser(int userId, int userIdToFollow) throws IOException, UserNotFoundException,
            UserAlreadyFollowedException;
    ResponseFollowersCountDTO countFollowers(int userId) throws UserNotFoundException;
    ResponseListFollowerDTO listFollowers(int userId, String order) throws UserNotFoundException;
    ResponseListFollowedDTO listFollowed(int userId, String order) throws UserNotFoundException;
    ResponseSimpleDTO generatePost(PostDTO request) throws UserNotFoundException, PostIdAlreadyAssignedException,
            DateNotValidException, IOException;
    ResponseRecentPostsDTO getRecentPosts(int userId, String order) throws UserNotFoundException;
    ResponseSimpleDTO unFollowUser(int userId, int userIdToUnFollow) throws IOException, UserNotFoundException;
}
