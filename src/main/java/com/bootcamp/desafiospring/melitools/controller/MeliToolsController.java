package com.bootcamp.desafiospring.melitools.controller;

import com.bootcamp.desafiospring.melitools.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(Constants.BASE_URL)
public class MeliToolsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MeliToolsController.class);

    @PostMapping(Constants.FOLLOW_ENDPOINT)
    public HttpStatus followUser(@PathVariable int userId, @PathVariable int userIdToFollow){
        LOGGER.info("Llamado al endpoint * Follow *");
        LOGGER.info("El usuario con userId {}, seguira al usuario con userId {}.", userId, userIdToFollow);
        return HttpStatus.OK;
    }
}
