package com.example.WorldOfAnimals.controllers;

import com.example.WorldOfAnimals.dto.AnimalDTO;
import com.example.WorldOfAnimals.dto.AnimalRequestDTO;
import com.example.WorldOfAnimals.dto.AnimalRequestPutDTO;
import com.example.WorldOfAnimals.exceptions.AnimalNotFoundException;
import com.example.WorldOfAnimals.services.AnimalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Animal created"),
    })
    @PostMapping
    public void saveAnimal(@RequestBody AnimalRequestDTO animalRequestDTO) {
        service.saveAnimal(animalRequestDTO);
    }

    @Operation(
            summary = "Retrieve an animal by ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retrieve an animal by ID",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = AnimalDTO.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Animal not found")
    })
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
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get all animals",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = AnimalDTO.class)))
                    })
    })
    @GetMapping
    public ResponseEntity<List<AnimalDTO>> getAnimals() {
        return ResponseEntity.ok(service.getAnimals());
    }

    @Operation(
            summary = "Update an animal by ID",
            description = "For successfully updating animal," +
                    " the animal breed must be existed in base"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Animal updated"),
            @ApiResponse(responseCode = "404",
                    description = "Animal for updating not found")
    })
    @PutMapping
    public ResponseEntity putAnimal(@RequestBody AnimalRequestPutDTO animalRequestPutDTO) {
        try {
            service.updateAnimal(animalRequestPutDTO);
            return ResponseEntity.ok().build();
        } catch (AnimalNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(
            summary = "Delete an animal by ID",
            description = "Delete from DB MySQL"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete type from DB")
    })
    @DeleteMapping("/{id}")
    void deleteAnimalById(@PathVariable(value = "id") Long id) {
        service.deleteAnimalById(id);
    }
}
