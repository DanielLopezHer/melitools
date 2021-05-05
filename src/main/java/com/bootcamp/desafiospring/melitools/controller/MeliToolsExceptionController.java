package com.bootcamp.desafiospring.melitools.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@Qualifier
public class MeliToolsExceptionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MeliToolsExceptionController.class);

    @ExceptionHandler(IOException.class)
    public void IOExceptionHandler(){
        LOGGER.info("No se pudo abrir el archivo.");
    }
}
