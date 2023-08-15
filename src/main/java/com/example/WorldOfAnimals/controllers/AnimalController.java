package com.example.WorldOfAnimals.controllers;

import com.example.WorldOfAnimals.exceptions.AnimalNotFoundException;
import com.example.WorldOfAnimals.models.AnimalEntity;
import com.example.WorldOfAnimals.services.AnimalService;
import com.example.WorldOfAnimals.services.AnimalsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animals/animals")
@AllArgsConstructor
public class AnimalController {

    private final AnimalService service;

    @GetMapping("/{id}")
    public ResponseEntity<AnimalEntity> getAnimalById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(service.getAnimalById(id));
        } catch (AnimalNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
