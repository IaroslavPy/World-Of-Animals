package com.example.WorldOfAnimals.controllers;

import com.example.WorldOfAnimals.exceptions.AnimalNotFoundException;
import com.example.WorldOfAnimals.models.AnimalBehavior;
import com.example.WorldOfAnimals.models.AnimalTypeEntity;
import com.example.WorldOfAnimals.models.AnimalsGroup;
import com.example.WorldOfAnimals.services.AnimalTypeService;
import com.example.WorldOfAnimals.services.AnimalsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/animalTypes")
@AllArgsConstructor
public class AnimalTypeController {

    private final AnimalTypeService service;

    @GetMapping
    public ResponseEntity<List<AnimalTypeEntity>> getAnimalTypes() {
        return ResponseEntity.ok(service.getAnimalsType());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalTypeEntity> getAnimalTypeById(@PathVariable("id") Integer id) {
        return service.getAnimalTypeById(id);
    }
}
