package com.bootcamp.desafiospring.melitools.service;

import com.bootcamp.desafiospring.melitools.dto.response.Response;
import com.bootcamp.desafiospring.melitools.repository.MeliToolsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeliToolsService {

    @Autowired
    private MeliToolsRepository mtRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(MeliToolsService.class);

    public Response followUser(int userId, int userIdToFollow) {
        LOGGER.info("Inicio de proceso de seguimiento.");
        return null;
    }
}
