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

    @PostConstruct
    private void loadSingleton() throws IOException {
        LOGGER.info("Se inicia el singleton de persistencia.");
        PersistenceSingleton.getInstance();
    }

}
