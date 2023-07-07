package com.example.WorldOfAnimals.controllers;


import com.example.WorldOfAnimals.exceptions.AnimalNotFoundException;
import com.example.WorldOfAnimals.models.AnimalBehavior;
import com.example.WorldOfAnimals.models.AnimalsGroup;
import com.example.WorldOfAnimals.services.AnimalsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animals")
@AllArgsConstructor
public class AnimalsController {

    private final AnimalsService service;

    @GetMapping
    public ResponseEntity<AnimalsGroup> getAnimals() {
        AnimalsGroup animalsGroup = service.getAnimals();
        return ResponseEntity.ok(animalsGroup);
    }

    @GetMapping("/{name}")
    public ResponseEntity<AnimalBehavior> getAnimal(@PathVariable("name") String nameAnimal) {
        try {
            AnimalBehavior animalBehavior = service.getAnimalBehavior(nameAnimal);
            return ResponseEntity.ok(animalBehavior);
        } catch (AnimalNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}