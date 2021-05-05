package com.bootcamp.desafiospring.melitools.controller;

import com.bootcamp.desafiospring.melitools.dto.ResponseErrorDTO;
import com.bootcamp.desafiospring.melitools.exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class MeliToolsExceptionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MeliToolsExceptionController.class);

    @ExceptionHandler(IOException.class)
    public void IOExceptionHandler(){
        LOGGER.info("No se pudo abrir el archivo.");
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseErrorDTO> UserNotFoundExceptionHandler(UserNotFoundException ex){
        LOGGER.info("No se encontro usuario solicitado.");
        LOGGER.info(ex.getMessage());
        return new ResponseEntity<>(ex.getErrorDTO(), HttpStatus.BAD_REQUEST);
    }
}
