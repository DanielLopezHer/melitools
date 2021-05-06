package com.bootcamp.desafiospring.melitools.exception;

import org.springframework.http.HttpStatus;

public class DateNotValidException extends MeliToolsException{
    public DateNotValidException(String mensaje, HttpStatus httpStatus) {
        super(mensaje, httpStatus);
    }
}
