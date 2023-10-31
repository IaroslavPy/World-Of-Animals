package com.example.WorldOfAnimals.controllers;

import com.example.WorldOfAnimals.dto.AnimalTypeDTO;
import com.example.WorldOfAnimals.dto.AnimalTypeRequestDTO;
import com.example.WorldOfAnimals.dto.ErrorResponseDTO;
import com.example.WorldOfAnimals.exceptions.AnimalTypeNameDuplicateException;
import com.example.WorldOfAnimals.exceptions.AnimalTypeNotFoundException;
import com.example.WorldOfAnimals.services.AnimalTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
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
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Type created"),
            @ApiResponse(responseCode = "422", description = "Duplicate unique animal type name",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))})
    })
    @PostMapping
    public ResponseEntity saveAnimalType(@RequestBody AnimalTypeRequestDTO animalTypeRequestDTO) {
        try {
            service.saveAnimalType(animalTypeRequestDTO);
            return ResponseEntity.status(201).build();
        } catch (AnimalTypeNameDuplicateException e) {
            return ResponseEntity.status(422)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(new ErrorResponseDTO("Duplicate unique animal type name",
                            "The name - " + animalTypeRequestDTO.getName() +
                                    " already exists and cannot be repeated"));
        }
    }

    @Operation(
            summary = "Retrieve all types of animal"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get all types",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = AnimalTypeDTO.class)))
                    })
    })
    @GetMapping
    public ResponseEntity<List<AnimalTypeDTO>> getAnimalTypes() {
        return ResponseEntity.ok(service.getAnimalsType());
    }

    @Operation(
            summary = "Retrieve an animal type by ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retrieve an animal type by ID",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = AnimalTypeDTO.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Type not found")
    })
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
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Type updated or created (if breed ID still don't exist in DB)"),
            @ApiResponse(responseCode = "422", description = "Duplicate unique type name",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorResponseDTO.class))
                    })
    })
    @PutMapping
    public ResponseEntity updateAnimalType(@RequestBody AnimalTypeDTO animalTypeDTO) {
        try {
            service.updateAnimalType(animalTypeDTO);
            return ResponseEntity.status(200).build();
        } catch (AnimalTypeNameDuplicateException e) {
            return ResponseEntity.status(422)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(new ErrorResponseDTO("Duplicate unique animal type name",
                            "The name - " + animalTypeDTO.getName() +
                                    " already exists and cannot be repeated"));
        }
    }

    @Operation(
            summary = "Delete a type of animal by ID",
            description = "Delete from DB MySQL"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete type from DB")
    })
    @DeleteMapping("/{id}")
    public void deleteAnimalTypeById(@PathVariable(value = "id") Integer id) {
        service.deleteAnimalTypeById(id);
    }
}
