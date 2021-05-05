package com.bootcamp.desafiospring.melitools.repository;

import com.bootcamp.desafiospring.melitools.dto.UserDTO;
import com.bootcamp.desafiospring.melitools.repository.collections.Userscollection;
import com.bootcamp.desafiospring.melitools.utils.PersistenceSingleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class MeliToolsRepository {

    private final PersistenceSingleton persistence = PersistenceSingleton.getInstance();

    private static final Logger LOGGER = LoggerFactory.getLogger(MeliToolsRepository.class);

    public MeliToolsRepository() throws IOException { }


    /**
     * Method to serach for a user using his id.
     * @author Daniel Alejandro López Hernández
     * @param userId {int} id of the user.
     * @return {UserDTO} user fount.
     * */
    public UserDTO searchUser(int userId){
        LOGGER.info("Se inicia búsqueda del usuario con id: {}", userId);
        return Userscollection.availableUsers.get(userId);
    }

    public boolean followUser() throws IOException {
        return persistence.updateUsersFile();
    }
}
