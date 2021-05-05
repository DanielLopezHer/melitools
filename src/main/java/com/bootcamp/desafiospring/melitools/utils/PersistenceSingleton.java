package com.bootcamp.desafiospring.melitools.utils;

import com.bootcamp.desafiospring.melitools.dto.UserDTO;
import com.bootcamp.desafiospring.melitools.repository.collections.Userscollection;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/*TODO: Documentar singleton junto con su clase de configuración. */
public class PersistenceSingleton {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersistenceSingleton.class);

    private static PersistenceSingleton instance;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private PersistenceSingleton() throws IOException {
        loadUsers();
    }

    public static PersistenceSingleton getInstance() throws IOException {
        if (instance == null) {
            LOGGER.info("Se genera singleton para persistencia.");
            instance = new PersistenceSingleton();
        }
        return instance;
    }

    private void loadUsers() throws IOException {
        UserDTO[] readedUsers = objectMapper.readValue(new File(Constants.USERS_FILE), UserDTO[].class);
        for (UserDTO usr : readedUsers) {
            Userscollection.availableUsers.put(usr.getUserId(), usr);
        }
        imprimeMapa("de usuarios generado:");
    }

    /*TODO: Borrar este método ya que solo es para probar el funcionamiento del singleton */
    private void imprimeMapa(String msj){
        LOGGER.info("Mapa {}: ", msj);
        LOGGER.info(Userscollection.availableUsers.toString());
    }

    public boolean updateUsersFile() throws IOException {
        LOGGER.info("Guardando cambios en archivo.");
        UserDTO[] newUsers = Userscollection.availableUsers.values().toArray(new UserDTO[0]);
        objectMapper.writeValue(new File(Constants.USERS_FILE), newUsers);
        return true;
    }

}
