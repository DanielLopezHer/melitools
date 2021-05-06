package com.bootcamp.desafiospring.melitools.controller;

import com.bootcamp.desafiospring.melitools.dto.ResponseErrorDTO;
import com.bootcamp.desafiospring.melitools.exception.*;
import com.bootcamp.desafiospring.melitools.utils.Constants;
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
        return new ResponseEntity<>(ex.getErrorDTO(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyFollowedException.class)
    public ResponseEntity<ResponseErrorDTO> UserAlreadyFollowedException(UserAlreadyFollowedException ex){
        LOGGER.info("El usuario solicitado ya se estaba siguiendo.");
        return new ResponseEntity<>(ex.getErrorDTO(), HttpStatus.BAD_REQUEST);
    }

    /*TODO: Documentar controller de exceptions*/

    @ExceptionHandler(PostIdAlreadyAssignedException.class)
    public ResponseEntity<ResponseErrorDTO> PostIdAlreadyAssignedException(PostIdAlreadyAssignedException ex){
        LOGGER.info("El id de la publicacion ya esta en uso.");
        return new ResponseEntity<>(ex.getErrorDTO(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductIdAlreadyAssignedException.class)
    public ResponseEntity<ResponseErrorDTO> ProductIdAlreadyAssignedException(ProductIdAlreadyAssignedException ex){
        LOGGER.info("El id del producto ya esta en uso.");
        return new ResponseEntity<>(ex.getErrorDTO(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DateNotValidException.class)
    public ResponseEntity<ResponseErrorDTO> DateNotValidException(DateNotValidException ex){
        LOGGER.info("La fecha ingresada deber ser mayor a la actual.");
        return new ResponseEntity<>(ex.getErrorDTO(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseErrorDTO> HttpMessageNotReadableException(){
        LOGGER.info("No se pudo parsear un dato del request.");
        return new ResponseEntity<>(new ResponseErrorDTO(Constants.ERROR_PARSE_EXCEPTION, Constants.MESSAGE_ERROR_PARSING),
                HttpStatus.BAD_REQUEST);
    }
}
