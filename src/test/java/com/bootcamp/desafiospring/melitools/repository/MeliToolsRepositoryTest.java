package com.bootcamp.desafiospring.melitools.repository;

import com.bootcamp.desafiospring.melitools.dto.UserDTO;
import com.bootcamp.desafiospring.melitools.utils.PersistenceSingleton;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MeliToolsRepositoryTest {
    @Autowired
    private MeliToolsRepository mtRepo;

    private static final Logger LOGGER = LoggerFactory.getLogger(MeliToolsRepositoryTest.class);
    private PersistenceSingleton persistence = PersistenceSingleton.getInstance();

    MeliToolsRepositoryTest() throws IOException {
    }

    @Test
    void searchUser() {
        LOGGER.info("Prueba de usuario no encontrado.");
        UserDTO unknownUser =  mtRepo.searchUser(1);
        LOGGER.info("Usuario: {}", unknownUser.toString());
    }
}