package com.example.WorldOfAnimals.utils;

import com.example.WorldOfAnimals.services.AnimalBreedService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class Listener {

    AnimalBreedService service;

    @PostConstruct
    @Scheduled(fixedRate = 86400000)
    public void getBreedsFromResources() {
        service.loadBreeds();
    }
}
