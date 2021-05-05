package com.bootcamp.desafiospring.melitools.exception;

import com.bootcamp.desafiospring.melitools.utils.Constants;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends MeliToolsException{

    public UserNotFoundException(int id) {
        super(Constants.ERROR_USER_NOT_FOUND + id, HttpStatus.BAD_REQUEST);
    }

}
