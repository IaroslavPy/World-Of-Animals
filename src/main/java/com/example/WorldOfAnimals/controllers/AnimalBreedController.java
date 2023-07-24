package com.example.WorldOfAnimals.controllers;

import com.example.WorldOfAnimals.models.AnimalBreedEntity;
import com.example.WorldOfAnimals.services.AnimalBreedService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animalBreeds")
@AllArgsConstructor
public class AnimalBreedController {

    private AnimalBreedService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createBreed(@RequestBody AnimalBreedEntity animalBreed){
        service.saveOrUpdate(animalBreed);
    }

}
