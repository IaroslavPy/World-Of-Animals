package com.example.WorldOfAnimals.controllers;


import com.example.WorldOfAnimals.models.AnimalBehavior;
import com.example.WorldOfAnimals.models.AnimalsGroup;
import com.example.WorldOfAnimals.services.AnimalsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animals")
public class AnimalsController {

    private final AnimalsService service;

    public AnimalsController(AnimalsService service) {
        this.service = service;
    }

    @GetMapping
    public AnimalsGroup getAnimals() {
        return service.getAnimals();
    }

    @GetMapping("/{name}")
    public AnimalBehavior getAnimal(@PathVariable("name") String nameAnimal) {
        return service.getAnimalBehavior(nameAnimal);
    }
}