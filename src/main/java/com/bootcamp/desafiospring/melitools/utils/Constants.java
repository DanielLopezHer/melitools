package com.bootcamp.desafiospring.melitools.utils;

public class Constants {
    /* Endpoints */
    public static final String BASE_URL = "/users";
    public static final String FOLLOW_ENDPOINT = "/{userId}/follow/{userIdToFollow}";
    public static final String FOLLOWERS_COUNT_ENDPOINT = "/{userId}/followers/count";
    public static final String LIST_FOLLOWERS_ENDPOINT = "/{userId}/followers/list";
    public static final String LIST_FOLLOWED_ENDPOINT = "/{userId}/followed/list";
    public static final String GENERATE_POST_ENDPOINT = "/products/newpost";
    public static final String GET_RECENT_POSTS = "/products/list/followed/{userId}";

    /* Files */
    public static final String USERS_FILE = "src/main/resources/templates/UsersFile.json";
    public static final String POSTS_FILE = "src/main/resources/templates/PostsFile.json";
    public static final String PRODUCTS_FILE = "src/main/resources/templates/ProductsFile.json";

    /* Messages */
    public static final String USER_FOLLOWED = "Se siguió al usuario correctamente.";
    public static final String ERROR_USER_FOLLOWED = "No se siguío el usuario.";
    public static final String ERROR_USER_NOT_FOUND = "No se encontro al usuario con id: ";
    public static final String USER_ALREADY_FOLLOWED = "El usuario %d ya está siendo seguido por el usuario %d.";

    public static final String POST_ID_ASSIGNED = "El id de la publicación ingresado ya está en uso.";
    public static final String DATE_NOT_VALID = "La fecha de la publicación debe ser superior a la actual.";
    public static final String POST_GENERATED = "!El post fue creado con éxito!";
    public static final String MESSAGE_ERROR_PARSING = "Por favor, verifica el contenido de tu petición.";

    /* Patterns */
    public static final String DATE_FORMAT = "dd-MM-yyyy";

    /* Time zone */
    /*TODO: revisar que cosas se pueden setear por properties */
    public static final String TIME_ZONE = "America/Mexico_City";

    /* Others */
    public static final String ERROR_PARSE_EXCEPTION = "HttpMessageNotReadableException";

    /* Numbers */
    public static final int PERIOD_FOR_RECENT_POSTS = -2;
}
