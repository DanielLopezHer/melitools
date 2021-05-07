package com.bootcamp.desafiospring.melitools.controller;

import com.bootcamp.desafiospring.melitools.dto.PostDTO;
import com.bootcamp.desafiospring.melitools.dto.response.BaseResponseDTO;
import com.bootcamp.desafiospring.melitools.dto.response.ResponseSimpleDTO;
import com.bootcamp.desafiospring.melitools.exception.DateNotValidException;
import com.bootcamp.desafiospring.melitools.exception.PostIdAlreadyAssignedException;
import com.bootcamp.desafiospring.melitools.exception.UserNotFoundException;
import com.bootcamp.desafiospring.melitools.service.MeliToolsService;
import com.bootcamp.desafiospring.melitools.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController()
public class MeliToolsProductsController {
    @Autowired
    private MeliToolsService mtService;

    private static final Logger LOGGER = LoggerFactory.getLogger(MeliToolsProductsController.class);

    /**
     * Create new publications and register products if they did not previously exist.
     * @author Daniel Alejandro López Hernández.*/
    @PostMapping(Constants.GENERATE_POST_ENDPOINT)
    public ResponseSimpleDTO generatePost(@RequestBody PostDTO request) throws UserNotFoundException,
            PostIdAlreadyAssignedException, DateNotValidException, IOException {
        LOGGER.info("Llamado al endpoint * Generate Post*");
        return mtService.generatePost(request);
    }

    /**
     * Resturs the list of the recent posts of the followed users of the user with id userId.
     * @author Daniel Alejandro López Hernández.*/
    @GetMapping(Constants.GET_RECENT_POSTS)
    public BaseResponseDTO getRecentPosts(@PathVariable int userId, @RequestParam(defaultValue = Constants.ORDER_METHOD_DATE_ASC)
            String order) throws UserNotFoundException {
        LOGGER.info("Llamado al endpoint * Recent Posts *");
        return mtService.getRecentPosts(userId, order);
    }
}
