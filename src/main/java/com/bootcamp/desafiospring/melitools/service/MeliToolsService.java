package com.bootcamp.desafiospring.melitools.service;

import com.bootcamp.desafiospring.melitools.dto.UserDTO;
import com.bootcamp.desafiospring.melitools.dto.response.Response;
import com.bootcamp.desafiospring.melitools.exception.UserNotFoundException;
import com.bootcamp.desafiospring.melitools.repository.MeliToolsRepository;
import com.bootcamp.desafiospring.melitools.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;

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
     * @return {Response} response with HttpStatus and message.*/
    public Response followUser(int userId, int userIdToFollow) throws IOException, UserNotFoundException {
        LOGGER.info("Inicio de accion Follow.");

        UserDTO follower = mtRepository.searchUser(userId);
        UserDTO followed = mtRepository.searchUser(userIdToFollow);

        follower.getFollowed().add(userIdToFollow);
        followed.getFollowers().add(userId);

        if (mtRepository.followUser())
            return new Response(HttpStatus.OK, Constants.USER_FOLLOWED);
        else
            return new Response(HttpStatus.BAD_REQUEST, Constants.ERROR_USER_FOLLOWED);
    }
}
