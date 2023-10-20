package com.example.WorldOfAnimals.controllers;

import com.example.WorldOfAnimals.dto.AnimalDTO;
import com.example.WorldOfAnimals.dto.AnimalRequestDTO;
import com.example.WorldOfAnimals.dto.AnimalRequestPutDTO;
import com.example.WorldOfAnimals.exceptions.AnimalNotFoundException;
import com.example.WorldOfAnimals.models.AnimalEntity;
import com.example.WorldOfAnimals.services.AnimalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(
        name = "Animals",
        description = "Manage animals by define (existed in base) breed of animal"
)
@RestController
@RequestMapping("/animals")
@AllArgsConstructor
public class AnimalController {

    private final AnimalService service;

    @Operation(
            summary = "Create new animal",
            description = "For successfully creating animal," +
                    " animal breed must be existed in base"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAnimal(@RequestBody AnimalRequestDTO animalRequestDTO) {
        service.saveAnimal(animalRequestDTO);
    }

    @Operation(
            summary = "Retrieve an animal by ID"
    )
    @GetMapping("/{id}")
    public ResponseEntity<AnimalDTO> getAnimalById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(service.getAnimalById(id));
        } catch (AnimalNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(
            summary = "Retrieve all animals"
    )
    @GetMapping
    public ResponseEntity<List<AnimalDTO>> getAnimals() {
        return ResponseEntity.ok(service.getAnimals());
    }

    @Operation(
            summary = "Update an animal by ID",
            description = "For successfully updating animal," +
                    " the animal breed must be existed in base"
    )
    @PutMapping
    public ResponseEntity<AnimalDTO> putAnimal(@RequestBody AnimalRequestPutDTO animalRequestPutDTO) {
        try {
            return ResponseEntity.ok(service.updateAnimal(animalRequestPutDTO));
        } catch (AnimalNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(
            summary = "Delete an animal by ID",
            description = "Delete from DB MySQL"
    )
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteAnimalById(@PathVariable(value = "id") Long id) {
        service.deleteAnimalById(id);
    }
}
