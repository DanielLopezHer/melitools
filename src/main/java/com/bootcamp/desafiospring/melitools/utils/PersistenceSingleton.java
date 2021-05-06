package com.bootcamp.desafiospring.melitools.utils;

import com.bootcamp.desafiospring.melitools.dto.PostDTO;
import com.bootcamp.desafiospring.melitools.dto.UserDTO;
import com.bootcamp.desafiospring.melitools.entity.ProductEntity;
import com.bootcamp.desafiospring.melitools.repository.collections.PostsCollection;
import com.bootcamp.desafiospring.melitools.repository.collections.ProductsCollection;
import com.bootcamp.desafiospring.melitools.repository.collections.Userscollection;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        loadPosts();
        loadProducts();
    }

    /**
     * Generate an instance of the singleton to simulate the database.
     * @author Daniel Alejandro López Hernández */
    public static PersistenceSingleton getInstance() throws IOException {
        if (instance == null) {
            LOGGER.info("Se genera singleton para persistencia.");
            instance = new PersistenceSingleton();
        }
        return instance;
    }

    /**
     * Reads and loads in memory the content of the UsersFile
     * @author Daniel Alejandro López Hernández
     * @throws IOException if the file was not found.*/
    private void loadUsers() throws IOException {
        UserDTO[] readedUsers = objectMapper.readValue(new File(Constants.USERS_FILE), UserDTO[].class);
        for (UserDTO usr : readedUsers) {
            Userscollection.availableUsers.put(usr.getUserId(), usr);
        }
        printMap("de usuarios generado:", 1);
    }

    /**
     * Utility to watch the content of a map in memory.
     * @author Daniel Alejandro López Hernández
     * @param msj {String} message to display
     * @param op {int} number of the map to display 1: users, 2: posts, 3: products*/
    private void printMap(String msj, int op){
        LOGGER.info("Mapa {}: ", msj);
        switch (op){
            case 1:
                LOGGER.info(Userscollection.availableUsers.toString());
                break;
            case 2:
                LOGGER.info(PostsCollection.availablePosts.toString());
                break;
            case 3:
                LOGGER.info(ProductsCollection.availableProducts.toString());
                break;
        }
    }

    /**
     * Method to persist changes of the Users map into the file
     * @author Daniel Alejandro López Hernández
     * @throws IOException if the file is was not found.*/
    public boolean updateUsersFile() throws IOException {
        LOGGER.info("Guardando cambios en archivo de usuarios.");
        UserDTO[] newUsers = Userscollection.availableUsers.values().toArray(new UserDTO[0]);
        objectMapper.writeValue(new File(Constants.USERS_FILE), newUsers);
        return true;
    }

    /**
     * Reads and loads in memory the content of the PostsFile
     * @author Daniel Alejandro López Hernández
     * @throws IOException if the file was not found.*/
    private void loadPosts() throws IOException{
        PostDTO[] readedPosts = objectMapper.readValue(new File(Constants.POSTS_FILE), PostDTO[].class);
        for (PostDTO post : readedPosts) {
            PostsCollection.availablePosts.put(post.getId_post(), post);
        }
        printMap("de posts generado:", 2);
    }

    /**
     * Reads and loads in memory the content of the ProductsFile
     * @author Daniel Alejandro López Hernández
     * @throws IOException if the file was not found.*/
    private void loadProducts() throws IOException{
        ProductEntity[] readedProducts = objectMapper.readValue(new File(Constants.PRODUCTS_FILE), ProductEntity[].class);
        for (ProductEntity product : readedProducts) {
            ProductsCollection.availableProducts.put(product.getProduct_id(), product);
        }
        printMap("de products generado:", 3);
    }

    /**
     * Method to persist changes of the Products map into the file
     * @author Daniel Alejandro López Hernández
     * @throws IOException if the file is was not found.*/
    public boolean updateProductFile() throws IOException {
        LOGGER.info("Guardando cambios en archivo de productos.");
        ProductEntity[] newProducts = ProductsCollection.availableProducts.values().toArray(new ProductEntity[0]);
        objectMapper.writeValue(new File(Constants.PRODUCTS_FILE), newProducts);
        return true;
    }

    /**
     * Method to persist changes of the Posts map into the file
     * @author Daniel Alejandro López Hernández
     * @throws IOException if the file is was not found.*/
    public boolean updatePostsFile() throws IOException {
        LOGGER.info("Guardando cambios en archivos de publicaciones.");
        PostDTO[] newPosts = PostsCollection.availablePosts.values().toArray(new PostDTO[0]);
        objectMapper.writeValue(new File(Constants.POSTS_FILE), newPosts);
        return true;
    }
}
