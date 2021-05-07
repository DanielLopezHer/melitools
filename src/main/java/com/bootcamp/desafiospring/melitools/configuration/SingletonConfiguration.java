package com.bootcamp.desafiospring.melitools.configuration;

import com.bootcamp.desafiospring.melitools.utils.PersistenceSingleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Configuration
public class SingletonConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(SingletonConfiguration.class);

    /**
     * initializes the singleton in charge of the persistence of the objects and loads in memory the content of the
     * files of the products, users and publications.
     * @author Daniel Alejandro López Hernández
     * @throws IOException if a file was not found.*/
    @PostConstruct
    private void loadSingleton() throws IOException {
        LOGGER.info("Se inicia el singleton de persistencia.");
        PersistenceSingleton.getInstance();
    }

}
