package com.bootcamp.desafiospring.melitools.controller;

import com.bootcamp.desafiospring.melitools.dto.response.Response;
import com.bootcamp.desafiospring.melitools.exception.UserAlreadyFollowedException;
import com.bootcamp.desafiospring.melitools.exception.UserNotFoundException;
import com.bootcamp.desafiospring.melitools.service.MeliToolsService;
import com.bootcamp.desafiospring.melitools.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController(Constants.BASE_URL)
public class MeliToolsController {

    @Autowired
    private MeliToolsService mtService;

    private static final Logger LOGGER = LoggerFactory.getLogger(MeliToolsController.class);

    /**
     * Performs "Follow" action
     * @author Daniel Alejandro López Hernández
     * */
    @PostMapping(Constants.FOLLOW_ENDPOINT)
    public Response followUser(@PathVariable int userId, @PathVariable int userIdToFollow) throws IOException, UserNotFoundException,
            UserAlreadyFollowedException {
        LOGGER.info("Llamado al endpoint * Follow *");
        return mtService.followUser(userId, userIdToFollow);
    }

    /**
     * Returns the number of followers of a user.
     * @author Daniel Alejandro López Hernández*/
    @GetMapping(Constants.FOLLOWERS_COUNT_ENDPOINT)
    public Response followersCount(@PathVariable int userId) throws UserNotFoundException {
        LOGGER.info("Llamado al endpoint * Count followers *");
        return mtService.countFollowers(userId);
    }
}
