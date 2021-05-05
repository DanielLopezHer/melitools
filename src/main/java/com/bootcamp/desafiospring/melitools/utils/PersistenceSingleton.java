package com.bootcamp.desafiospring.melitools.utils;

import com.bootcamp.desafiospring.melitools.dto.UserDTO;
import com.bootcamp.desafiospring.melitools.repository.collections.Userscollection;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.User;
import org.apache.catalina.startup.UserConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

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

    /* Cargar en memoria el contenido de los archivos */
    // 1) Poder abrir el archivo
    private void loadUsers() throws IOException {
        UserDTO[] readedUsers = objectMapper.readValue(new File(Constants.USERS_FILE), UserDTO[].class);
        for (UserDTO usr : readedUsers) {
            Userscollection.availableUsers.put(usr.getUserId(), usr);
        }
        imprimeMapa("generado:");
        UserDTO newUsr = new UserDTO(3, "Paola", "Alonso");

        /* Agregar nuevo usuario */
        Userscollection.availableUsers.put(newUsr.getUserId(), newUsr);
        imprimeMapa("nuevo usuario.");

        /* Modificar info de un usuario */
        UserDTO userPrueba = Userscollection.availableUsers.get(1);
        LOGGER.info("Usuario antes de modificar: {}", userPrueba.toString());
        userPrueba.getFollowed().add(1000);
        LOGGER.info("Usuario de prueba modificado: {}", userPrueba.toString());

        /* Acutalizar info del archivo */
        UserDTO[] newUsers = Userscollection.availableUsers.values().toArray(new UserDTO[0]);
        objectMapper.writeValue(new File(Constants.USERS_FILE), newUsers);
        imprimeMapa("actualizado.");

    }

    /*TODO: Borrar este método ya que solo es para probar el funcionamiento del singleton */
    private void imprimeMapa(String msj){
        LOGGER.info("Mapa {}: ", msj);
        LOGGER.info(Userscollection.availableUsers.toString());
    }

}
