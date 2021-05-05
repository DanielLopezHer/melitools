package com.bootcamp.desafiospring.melitools.service;

import com.bootcamp.desafiospring.melitools.dto.UserDTO;
import com.bootcamp.desafiospring.melitools.dto.response.BaseResponse;
import com.bootcamp.desafiospring.melitools.dto.response.ResponseList;
import com.bootcamp.desafiospring.melitools.dto.response.ResponseSimple;
import com.bootcamp.desafiospring.melitools.dto.response.ResponseFollowersCount;
import com.bootcamp.desafiospring.melitools.entity.UserListNode;
import com.bootcamp.desafiospring.melitools.exception.UserAlreadyFollowedException;
import com.bootcamp.desafiospring.melitools.exception.UserNotFoundException;
import com.bootcamp.desafiospring.melitools.repository.MeliToolsRepository;
import com.bootcamp.desafiospring.melitools.utils.Constants;
import com.bootcamp.desafiospring.melitools.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;

@Service
public class MeliToolsService {

    @Autowired
    private MeliToolsRepository mtRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(MeliToolsService.class);

    /**
     * Method to follow a user
     * @author Daniel Alejandro López Hernández
     * @param userId {int} id of the user who wants to follow other user.
     * @param userIdToFollow {int} id of the user who is going to be followed.
     * @return {Response} response with HttpStatus and message.
     * @throws IOException if the singleto doesn't find the users file.
     * @throws UserNotFoundException if the user with one of the received ids doesn't exists.*/
    public ResponseSimple followUser(int userId, int userIdToFollow) throws IOException, UserNotFoundException,
            UserAlreadyFollowedException {
        LOGGER.info("Inicio de accion Follow.");

        UserDTO follower = mtRepository.searchUser(userId);
        UserDTO followed = mtRepository.searchUser(userIdToFollow);

        if(Utils.searchIdInList(follower.getFollowed(), followed.getUserId())){
            LOGGER.info("El usuario aun no seguia al otro usuario.");
            follower.getFollowed().add(userIdToFollow);
        }else
            throw new UserAlreadyFollowedException(followed.getUserId(), follower.getUserId());

        if (Utils.searchIdInList(followed.getFollowers(), follower.getUserId())){
            LOGGER.info("El usuario aun no era seguido por el otro usuario.");
            followed.getFollowers().add(userId);
        }else
            throw new UserAlreadyFollowedException(followed.getUserId(), follower.getUserId());

        if (mtRepository.followUser())
            return new ResponseSimple(Constants.USER_FOLLOWED, HttpStatus.OK);
        else
            return new ResponseSimple(Constants.ERROR_USER_FOLLOWED, HttpStatus.BAD_REQUEST);
    }

    /**
     * Method to get the number of followers of a user
     * @author Daniel Alejandro López Hernández
     * @param userId {int} id of the user
     * @return {ResponseFollowersCount} response with the number of followers of the user with id "userId".*/
    public ResponseFollowersCount countFollowers(int userId) throws UserNotFoundException {
        UserDTO user = mtRepository.searchUser(userId);
        ResponseFollowersCount response = new ResponseFollowersCount(user.getUserId(), user.getName(),
                user.getFollowers().size());
        LOGGER.info("Response generado: {}", response.toString());
        return response;
    }

    /**
     * Method to get the list of followers of a user.
     * @author Daniel Alejandro López Hernández
     * @param userId {int} id of the user
     * @return {ResponseList} response with the list of users*/
    public ResponseList listFollowers(int userId) throws UserNotFoundException {
        UserDTO user = mtRepository.searchUser(userId);
        UserListNode[] followersInfo = new UserListNode[user.getFollowers().size()];
        int index = 0;
        for (int i : user.getFollowers() ) {
            UserListNode node = new UserListNode(i, mtRepository.searchUser(i).getName());
            followersInfo[index] = node;
            index++;
        }
        LOGGER.info("El array de seguidores es: {}", Arrays.toString(followersInfo));
        return new ResponseList(userId, user.getName(), followersInfo);
    }
}
