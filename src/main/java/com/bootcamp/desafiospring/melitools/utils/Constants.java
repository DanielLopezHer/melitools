package com.bootcamp.desafiospring.melitools.utils;

public class Constants {
    /* Endpoints */
    public static final String BASE_URL = "/users";
    public static final String FOLLOW_ENDPOINT = "/{userId}/follow/{userIdToFollow}";
    public static final String FOLLOWERS_COUNT_ENDPOINT = "/{userId}/followers/count";
    public static final String LIST_FOLLOWERS_ENDPOINT = "/{userId}/followers/list";
    public static final String LIST_FOLLOWED_ENDPOINT = "/{userId}/followed/list";
    public static final String GENERATE_POST_ENDPOINT = "/products/newpost";

    /* Files */
    public static final String USERS_FILE = "src/main/resources/templates/UsersFile.json";
    public static final String POSTS_FILE = "src/main/resources/templates/PostsFile.json";
    public static final String PRODUCTS_FILE = "src/main/resources/templates/ProductsFile.json";

    /* Messages */
    public static final String USER_FOLLOWED = "Se siguió al usuario correctamente.";
    public static final String ERROR_USER_FOLLOWED = "No se siguío el usuario.";
    public static final String ERROR_USER_NOT_FOUND = "No se encontro al usuario con id: ";
    public static final String USER_ALREADY_FOLLOWED = "El usuario %d ya está siendo seguido por el usuario %d.";

    /* Patterns */
    public static final String DATE_FORMAT = "DD-MM-YYYY";
}
