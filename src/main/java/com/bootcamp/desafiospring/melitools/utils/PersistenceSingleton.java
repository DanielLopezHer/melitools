package com.bootcamp.desafiospring.melitools.utils;

import com.bootcamp.desafiospring.melitools.dto.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class PersistenceSingleton {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersistenceSingleton.class);

    private static PersistenceSingleton instance;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private PersistenceSingleton(){ }

    public static PersistenceSingleton getInstance() {
        if (instance == null) {
            LOGGER.info("Se genera singleton para persistencia.");
            instance = new PersistenceSingleton();
        }
        return instance;
    }

    /* Cargar en memoria el contenido de los archivos */
    // 1) Poder abrir el archivo
    public void loadUsers() throws IOException {
        UserDTO[] readedUsers = objectMapper.readValue(new File(Constants.USERS_FILE), UserDTO[].class);
        for (UserDTO usr : readedUsers) {
            LOGGER.info(usr.toString());
        }
    }

}
