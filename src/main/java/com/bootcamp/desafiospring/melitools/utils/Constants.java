package com.bootcamp.desafiospring.melitools.utils;

public class Constants {
    /* Endpoints */
    public static final String BASE_URL_USERS = "/users";
    public static final String BASE_URL_PRODUCTS = "/products";
    public static final String FOLLOW_ENDPOINT = "/{userId}/follow/{userIdToFollow}";
    public static final String FOLLOWERS_COUNT_ENDPOINT = "/{userId}/followers/count";
    public static final String LIST_FOLLOWERS_ENDPOINT = "/{userId}/followers/list";
    public static final String LIST_FOLLOWED_ENDPOINT = "/{userId}/followed/list";
    public static final String GENERATE_POST_ENDPOINT = "/products/newpost";
    public static final String GET_RECENT_POSTS = "/products/list/followed/{userId}";
    public static final String UNFOLLOW_ENDPOINT = "/{userId}/unfollow/{userIdToUnFollow}";

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

    public static final String USER_UNFOLLOWED = "Se dejó de seguir al usuario correctamente.";
    public static final String MESSAGE_PATH_VARIABLE_ERROR = "Request incorrecto, favor de revisar su URL.";

    /* Patterns */
    public static final String DATE_FORMAT = "dd-MM-yyyy";

    /* Time zone */
    public static final String TIME_ZONE = "America/Mexico_City";

    /* Others */
    public static final String ERROR_PARSE_EXCEPTION = "HttpMessageNotReadableException";
    public static final String ERROR_PATH_VARIABLE_EXCEPTION = "MethodArgumentTypeMismatchException";

    /* Numbers */
    public static final int PERIOD_FOR_RECENT_POSTS = -2;

    /* Orders */
    public static final String ORDER_METHOD_NAME_ASC = "name_asc";
    public static final String ORDER_METHOD_DATE_ASC = "date_asc";
}
