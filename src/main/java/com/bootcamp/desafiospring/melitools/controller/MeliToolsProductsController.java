package com.bootcamp.desafiospring.melitools.controller;

import com.bootcamp.desafiospring.melitools.dto.PostDTO;
import com.bootcamp.desafiospring.melitools.dto.response.ResponseSimple;
import com.bootcamp.desafiospring.melitools.exception.UserNotFoundException;
import com.bootcamp.desafiospring.melitools.service.MeliToolsService;
import com.bootcamp.desafiospring.melitools.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class MeliToolsProductsController {
    @Autowired
    private MeliToolsService mtService;

    private static final Logger LOGGER = LoggerFactory.getLogger(MeliToolsProductsController.class);

    @PostMapping(Constants.GENERATE_POST_ENDPOINT)
    public ResponseSimple generatePost(@RequestBody PostDTO request) throws UserNotFoundException {
        LOGGER.info("Llamado al endpoint * Generate Post*");
        return mtService.generatePost(request);
    }
}
