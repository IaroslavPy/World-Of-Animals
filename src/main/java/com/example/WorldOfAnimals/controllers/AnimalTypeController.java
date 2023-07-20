package com.example.WorldOfAnimals.controllers;

import com.example.WorldOfAnimals.exceptions.AnimalTypeNotFoundException;
import com.example.WorldOfAnimals.models.AnimalTypeEntity;
import com.example.WorldOfAnimals.services.AnimalTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/animalTypes")
@AllArgsConstructor
public class AnimalTypeController {

    private final AnimalTypeService service;

    @PostMapping
    public AnimalTypeEntity saveAnimalType(@RequestBody AnimalTypeEntity animalType) {
        return service.saveOrUpdate(animalType);
    }

    @GetMapping
    public ResponseEntity<List<AnimalTypeEntity>> getAnimalTypes() {
        return ResponseEntity.ok(service.getAnimalsType());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalTypeEntity> getAnimalTypeById(@PathVariable("id") Integer id) {
        try {
            AnimalTypeEntity animalType = service.getAnimalTypeById(id);
            return ResponseEntity.ok(animalType);
        } catch (AnimalTypeNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public AnimalTypeEntity updateAnimalType(@RequestBody AnimalTypeEntity animalType) {
        return service.saveOrUpdate(animalType);
    }

    @DeleteMapping("/{id}")
    public void deleteAnimalTypeById(@PathVariable(value = "id") Integer id) {
        service.deleteAnimalTypeById(id);
    }
}
