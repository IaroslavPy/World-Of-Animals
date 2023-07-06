package com.example.WorldOfAnimals.controllers;


import com.example.WorldOfAnimals.models.AnimalBehavior;
import com.example.WorldOfAnimals.models.AnimalsGroup;
import com.example.WorldOfAnimals.services.AnimalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AnimalsController {

    @Autowired
    private AnimalsService service;


    @GetMapping
    public AnimalBehavior getAnimal() {
        return service.getAnimalBehavior();
    }

    @GetMapping("/animals")
    public AnimalsGroup getAnimals() {
        return service.getAnimals();
    }
}
