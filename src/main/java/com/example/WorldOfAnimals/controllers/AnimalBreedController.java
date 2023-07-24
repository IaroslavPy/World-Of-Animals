package com.example.WorldOfAnimals.controllers;

import com.example.WorldOfAnimals.models.AnimalBreedEntity;
import com.example.WorldOfAnimals.services.AnimalBreedService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<AnimalBreedEntity>> getBreeds(){
        return ResponseEntity.ok(service.getAnimalsBreeds());
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBreedById(@PathVariable(value = "id") Integer id){
        service.deleteByID(id);
    }
}
