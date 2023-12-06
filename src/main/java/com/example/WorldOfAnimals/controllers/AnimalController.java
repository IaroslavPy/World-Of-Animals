package com.example.WorldOfAnimals.controllers;

import com.example.WorldOfAnimals.dto.AnimalDTO;
import com.example.WorldOfAnimals.dto.AnimalRequestDTO;
import com.example.WorldOfAnimals.dto.AnimalRequestPutDTO;
import com.example.WorldOfAnimals.dto.ErrorResponseDTO;
import com.example.WorldOfAnimals.services.AnimalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

import javax.validation.constraints.NotNull;

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
    @ResponseStatus(HttpStatus.CREATED)
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
            @ApiResponse(responseCode = "404", description = "Animal not found",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorResponseDTO.class))
                    })
    })
    @GetMapping("/{id}")
    public ResponseEntity<AnimalDTO> findAnimalById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getAnimalById(id));
    }

    @Operation(
            summary = "Retrieve all animals with pagination"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get all animals (pagination)")
    })
    @GetMapping
    public Page<AnimalDTO> getPaginatedAnimals(
            @PageableDefault(size = 5, sort = "name")
            @ParameterObject @NotNull Pageable pageable) {
        return service.getPaginatedAnimals(pageable);
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
                    description = "Animal for updating not found",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorResponseDTO.class))
                    })
    })
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateAnimal(@RequestBody AnimalRequestPutDTO animalRequestPutDTO) {
        service.updateAnimal(animalRequestPutDTO);
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
