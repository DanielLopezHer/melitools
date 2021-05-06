package com.bootcamp.desafiospring.melitools.exception;

import org.springframework.http.HttpStatus;

public class PostIdAlreadyAssignedException extends MeliToolsException{
    public PostIdAlreadyAssignedException(String mensaje, HttpStatus httpStatus) {
        super(mensaje, httpStatus);
    }
}
