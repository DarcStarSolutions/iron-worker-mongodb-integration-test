package org.darcstarsolutions.ironworker.mongodb;

import org.darcstarsolutions.ironworker.mongodb.configuration.TimeStampRepository;
import org.darcstarsolutions.ironworker.mongodb.entities.TimeStamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

/**
 * Created by mharris on 5/27/15.
 */

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private TimeStampRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        TimeStamp timeStamp = new TimeStamp();
        timeStamp.setTime(System.currentTimeMillis());
        timeStamp.setUuid(UUID.randomUUID());
        repository.save(timeStamp);
    }
}
