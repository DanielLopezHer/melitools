package com.bootcamp.desafiospring.melitools.controller;

import com.bootcamp.desafiospring.melitools.dto.response.BaseResponseDTO;
import com.bootcamp.desafiospring.melitools.dto.response.ResponseSimpleDTO;
import com.bootcamp.desafiospring.melitools.exception.UserAlreadyFollowedException;
import com.bootcamp.desafiospring.melitools.exception.UserNotFoundException;
import com.bootcamp.desafiospring.melitools.service.MeliToolsService;
import com.bootcamp.desafiospring.melitools.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController(Constants.BASE_URL_USERS)
public class MeliToolsUsersController {

    @Autowired
    private MeliToolsService mtService;

    private static final Logger LOGGER = LoggerFactory.getLogger(MeliToolsUsersController.class);

    /**
     * Performs "Follow" action
     * @author Daniel Alejandro López Hernández
     * */
    @PostMapping(Constants.FOLLOW_ENDPOINT)
    public ResponseSimpleDTO followUser(@PathVariable int userId, @PathVariable int userIdToFollow) throws IOException, UserNotFoundException,
            UserAlreadyFollowedException {
        LOGGER.info("Llamado al endpoint * Follow *");
        return mtService.followUser(userId, userIdToFollow);
    }

    /**
     * Returns the number of followers of a user.
     * @author Daniel Alejandro López Hernández*/
    @GetMapping(Constants.FOLLOWERS_COUNT_ENDPOINT)
    public BaseResponseDTO followersCount(@PathVariable int userId) throws UserNotFoundException {
        LOGGER.info("Llamado al endpoint * Count followers *");
        return mtService.countFollowers(userId);
    }

    /**
     * Returns the list of followers of a user.
     * @author Daniel Alejandro López Hernández.*/
    @GetMapping(Constants.LIST_FOLLOWERS_ENDPOINT)
    public BaseResponseDTO listFollowers(@PathVariable int userId, @RequestParam(defaultValue = Constants.ORDER_METHOD_NAME_ASC)
            String order) throws UserNotFoundException {
        LOGGER.info("Llamado al endpoint * List followers *");
        return mtService.listFollowers(userId, order);
    }

    /**
     * Returns the list of followed sellers of a user.
     * @author Daniel Alejandro López Hernández.*/
    @GetMapping(Constants.LIST_FOLLOWED_ENDPOINT)
    public BaseResponseDTO listFollowed(@PathVariable int userId, @RequestParam(defaultValue = Constants.ORDER_METHOD_NAME_ASC)
            String order) throws UserNotFoundException {
        LOGGER.info("Llamado al endpoint * List followed *");
        return mtService.listFollowed(userId, order);
    }

    /**
     * Performs "Unfollow" action
     * @author Daniel Alejandro López Hernández
     * */
    @PostMapping(Constants.UNFOLLOW_ENDPOINT)
    public ResponseSimpleDTO unFollowUser(@PathVariable int userId, @PathVariable int userIdToUnFollow) throws IOException, UserNotFoundException {
        LOGGER.info("Llamado al endpoint * Unfollow *");
        return mtService.unFollowUser(userId, userIdToUnFollow);
    }
}
