package com.example.WorldOfAnimals.controllers;

import com.example.WorldOfAnimals.dto.AnimalBreedDTO;
import com.example.WorldOfAnimals.dto.AnimalBreedRequestDTO;
import com.example.WorldOfAnimals.services.AnimalBreedService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(
        name = "Animal breeds",
        description = "Manage animal breeds by define " +
                "(existed in base) animal type"
)
@RestController
@RequestMapping("/animals/breeds")
@AllArgsConstructor
public class AnimalBreedController {

    private AnimalBreedService service;

    @Operation(
            summary = "Create new breed of animal",
            description = "For successfully creating animal breeds," +
                    " the animal type must be existed in base"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createBreed(@RequestBody AnimalBreedRequestDTO breedRequestDTO) {
        service.save(breedRequestDTO);
    }

    @Operation(
            summary = "Retrieve all breeds of animal"
    )
    @GetMapping
    public ResponseEntity<List<AnimalBreedDTO>> getBreeds() {
        return ResponseEntity.ok(service.getAnimalsBreeds());
    }

    @Operation(
            summary = "Retrieve all breeds of animal (by page)"
    )
    @GetMapping("/page")
    public ResponseEntity<List<AnimalBreedDTO>> getAnimalsBreedsPage(
            @Parameter(description = "Page number")
            @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
            @Parameter(description = "Count of items on page")
            @RequestParam(value = "size", defaultValue = "1") Integer size) {
        return ResponseEntity.ok(service.getAnimalsBreedsPage(pageNo, size));
    }

    @Operation(
            summary = "Delete a breed of animal by ID",
            description = "Delete from DB MySQL"
    )
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBreedById(@PathVariable(value = "id") Integer id) {
        service.deleteByID(id);
    }
}
