package com.bootcamp.desafiospring.melitools.repository;

import com.bootcamp.desafiospring.melitools.dto.UserDTO;
import com.bootcamp.desafiospring.melitools.exception.UserNotFoundException;
import com.bootcamp.desafiospring.melitools.repository.collections.PostsCollection;
import com.bootcamp.desafiospring.melitools.repository.collections.ProductsCollection;
import com.bootcamp.desafiospring.melitools.repository.collections.Userscollection;
import com.bootcamp.desafiospring.melitools.utils.Constants;
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
    public UserDTO searchUser(int userId) throws UserNotFoundException {
        LOGGER.info("Se inicia búsqueda del usuario con id: {}", userId);
        UserDTO userFound = Userscollection.availableUsers.get(userId);
        if (userFound != null) {
            LOGGER.info("Se encotro el usuario.");
            return userFound;
        }
        else
            throw new UserNotFoundException(userId);
    }

    /**
     * Method to persist the info when a user is followed by another user.
     * @author Daniel Alejandro López Hernández
     * @return {boolean} returns true if the file was updated.
     * @throws IOException in case of don't find the users file.*/
    public boolean followUser() throws IOException {
        return persistence.updateUsersFile();
    }

    /**
     * Method to identify if a post id already exists
     * @author Daniel Alejandro López Hernández
     * @param id {int} id to search
     * @return {boolean} true if the id don't exists*/
    public boolean searchPostId(int id){
        LOGGER.info("Buscando id {} en publicaciones.", id);
        return !PostsCollection.availablePosts.containsKey(id);
    }

    /**
     * Method to identify if a product id already exists
     * @author Daniel Alejandro López Hernández
     * @param id {int} id to search
     * @return {boolean} true if the id don't exists*/
    public boolean searchProductId(int id){
        LOGGER.info("Buscando id {} en productos.", id);
        return !ProductsCollection.availableProducts.containsKey(id);
    }
}
