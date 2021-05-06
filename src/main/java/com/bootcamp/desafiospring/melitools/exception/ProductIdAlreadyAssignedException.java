package com.bootcamp.desafiospring.melitools.exception;

import org.springframework.http.HttpStatus;

public class ProductIdAlreadyAssignedException extends MeliToolsException{
    public ProductIdAlreadyAssignedException(String mensaje, HttpStatus httpStatus) {
        super(mensaje, httpStatus);
    }
}
