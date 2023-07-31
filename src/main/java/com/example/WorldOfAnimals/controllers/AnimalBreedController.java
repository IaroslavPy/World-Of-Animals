package com.example.WorldOfAnimals.controllers;

import com.example.WorldOfAnimals.dto.AnimalBreedDTO;
import com.example.WorldOfAnimals.dto.AnimalBreedRequestDTO;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/animals/breeds")
@AllArgsConstructor
public class AnimalBreedController {

    private AnimalBreedService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createBreed(@RequestBody AnimalBreedRequestDTO breedRequestDTO) {
        service.save(breedRequestDTO);
    }

    @GetMapping
    public ResponseEntity<List<AnimalBreedDTO>> getBreeds() {
        return ResponseEntity.ok(service.getAnimalsBreeds());
    }

    @GetMapping("/page")
    public ResponseEntity<List<AnimalBreedDTO>> getAnimalsBreedsPage(
            @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
            @RequestParam(value = "size", defaultValue = "1") Integer size) {
        return ResponseEntity.ok(service.getAnimalsBreedsPage(pageNo, size));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBreedById(@PathVariable(value = "id") Integer id) {
        service.deleteByID(id);
    }
}
