package com.example.WorldOfAnimals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WorldOfAnimalsApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorldOfAnimalsApplication.class, args);
    }
}
