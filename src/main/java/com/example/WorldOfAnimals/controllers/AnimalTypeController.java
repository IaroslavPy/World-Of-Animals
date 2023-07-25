package com.example.WorldOfAnimals.controllers;

import com.example.WorldOfAnimals.dto.AnimalTypeDTO;
import com.example.WorldOfAnimals.exceptions.AnimalTypeNotFoundException;
import com.example.WorldOfAnimals.services.AnimalTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/animalTypes")
@AllArgsConstructor
public class AnimalTypeController {

    private final AnimalTypeService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAnimalType(@RequestBody AnimalTypeDTO animalTypeDTO) {
        service.saveOrUpdate(animalTypeDTO);
    }

    @GetMapping
    public ResponseEntity<List<AnimalTypeDTO>> getAnimalTypes() {
        return ResponseEntity.ok(service.getAnimalsType());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalTypeDTO> getAnimalTypeById(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.ok(service.getAnimalTypeById(id));
        } catch (AnimalTypeNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateAnimalType(@RequestBody AnimalTypeDTO animalTypeDTO) {
        service.saveOrUpdate(animalTypeDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAnimalTypeById(@PathVariable(value = "id") Integer id) {
        service.deleteAnimalTypeById(id);
    }
}
