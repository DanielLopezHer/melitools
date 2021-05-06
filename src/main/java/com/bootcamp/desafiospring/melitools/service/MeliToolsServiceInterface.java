package com.bootcamp.desafiospring.melitools.service;

import com.bootcamp.desafiospring.melitools.dto.PostDTO;
import com.bootcamp.desafiospring.melitools.dto.response.ResponseFollowersCount;
import com.bootcamp.desafiospring.melitools.dto.response.ResponseList;
import com.bootcamp.desafiospring.melitools.dto.response.ResponseRecentPosts;
import com.bootcamp.desafiospring.melitools.dto.response.ResponseSimple;
import com.bootcamp.desafiospring.melitools.exception.DateNotValidException;
import com.bootcamp.desafiospring.melitools.exception.PostIdAlreadyAssignedException;
import com.bootcamp.desafiospring.melitools.exception.UserAlreadyFollowedException;
import com.bootcamp.desafiospring.melitools.exception.UserNotFoundException;

import java.io.IOException;

public interface MeliToolsServiceInterface {
    ResponseSimple followUser(int userId, int userIdToFollow) throws IOException, UserNotFoundException,
            UserAlreadyFollowedException;
    ResponseFollowersCount countFollowers(int userId) throws UserNotFoundException;
    ResponseList listFollowers(int userId, String order) throws UserNotFoundException;
    ResponseList listFollowed(int userId, String order) throws UserNotFoundException;
    ResponseSimple generatePost(PostDTO request) throws UserNotFoundException, PostIdAlreadyAssignedException,
            DateNotValidException, IOException;
    ResponseRecentPosts getRecentPosts(int userId, String order) throws UserNotFoundException;
    ResponseSimple unFollowUser(int userId, int userIdToUnFollow) throws IOException, UserNotFoundException;
}
