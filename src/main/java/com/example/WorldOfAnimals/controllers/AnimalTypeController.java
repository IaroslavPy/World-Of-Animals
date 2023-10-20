package com.example.WorldOfAnimals.controllers;

import com.example.WorldOfAnimals.dto.AnimalTypeDTO;
import com.example.WorldOfAnimals.dto.AnimalTypeRequestDTO;
import com.example.WorldOfAnimals.exceptions.AnimalTypeNotFoundException;
import com.example.WorldOfAnimals.services.AnimalTypeService;
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
        name = "Animal types",
        description = "Manage animal types"
)
@RestController
@RequestMapping("/animals/types")
@AllArgsConstructor
public class AnimalTypeController {

    private final AnimalTypeService service;

    @Operation(
            summary = "Create new type of animal"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAnimalType(@RequestBody AnimalTypeRequestDTO animalTypeRequestDTO) {
        service.saveAnimalType(animalTypeRequestDTO);
    }

    @Operation(
            summary = "Retrieve all types of animal"
    )
    @GetMapping
    public ResponseEntity<List<AnimalTypeDTO>> getAnimalTypes() {
        return ResponseEntity.ok(service.getAnimalsType());
    }

    @Operation(
            summary = "Retrieve an animal type by ID"
    )
    @GetMapping("/{id}")
    public ResponseEntity<AnimalTypeDTO> getAnimalTypeById(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.ok(service.getAnimalTypeById(id));
        } catch (AnimalTypeNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(
            summary = "Update a type of animal",
            description = "For successfully updating a type of animal," +
                    " the type of animal must be existed in base"
    )
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateAnimalType(@RequestBody AnimalTypeDTO animalTypeDTO) {
        service.updateAnimalType(animalTypeDTO);
    }

    @Operation(
            summary = "Delete a type of animal by ID",
            description = "Delete from DB MySQL"
    )
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAnimalTypeById(@PathVariable(value = "id") Integer id) {
        service.deleteAnimalTypeById(id);
    }
}
