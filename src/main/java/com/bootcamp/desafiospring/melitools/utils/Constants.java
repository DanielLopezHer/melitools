package com.bootcamp.desafiospring.melitools.utils;

public class Constants {
    /* Endpoints */
    public static final String BASE_URL = "/users";
    public static final String FOLLOW_ENDPOINT = "/{userId}/follow/{userIdToFollow}";

    /* Files */
    public static final String USERS_FILE = "src/main/resources/templates/UsersFile.json";

    /* Messages */
    public static final String USER_FOLLOWED = "Se siguió al usuario correctamente.";
    public static final String ERROR_USER_FOLLOWED = "No se siguío el usuario.";
    public static final String ERROR_USER_NOT_FOUND = "No se encontro al usuario con id: ";
    public static final String USER_ALREADY_FOLLOWED = "El usuario %d ya está siendo seguido por el usuario %d.";
}
