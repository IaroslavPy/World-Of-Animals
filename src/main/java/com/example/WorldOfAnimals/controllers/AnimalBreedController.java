package com.example.WorldOfAnimals.controllers;

import com.example.WorldOfAnimals.dto.AnimalBreedDTO;
import com.example.WorldOfAnimals.dto.AnimalBreedRequestDTO;
import com.example.WorldOfAnimals.dto.AnimalBreedRequestPutDTO;
import com.example.WorldOfAnimals.dto.ErrorResponseDTO;
import com.example.WorldOfAnimals.exceptions.AnimalBreedNameDuplicateException;
import com.example.WorldOfAnimals.services.AnimalBreedService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
import org.springframework.web.bind.annotation.RequestParam;
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
                    " the animal type (ID) must be existed in base"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Breed created"),
            @ApiResponse(responseCode = "422", description = "Duplicate unique animal breed name",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))}),
    })
    @PostMapping
    public ResponseEntity createBreed(@RequestBody AnimalBreedRequestDTO breedRequestDTO) {
        try {
            service.save(breedRequestDTO);
            return ResponseEntity.status(201).build();
        } catch (AnimalBreedNameDuplicateException e) {
            return ResponseEntity.status(422)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(new ErrorResponseDTO("Duplicate unique animal breed name",
                            "The name - " + breedRequestDTO.getName() +
                                    " already exists and cannot be repeated"));
        }
    }

    @Operation(
            summary = "Retrieve all breeds of animal"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get all breeds",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = AnimalBreedDTO.class)))
                    })
    })
    @GetMapping
    public ResponseEntity<List<AnimalBreedDTO>> getBreeds() {
        return ResponseEntity.ok(service.getAnimalsBreeds());
    }

    @Operation(
            summary = "Retrieve all breeds of animal (by page)"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get all breeds (by page)",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = AnimalBreedDTO.class)))
                    })
    })
    @GetMapping("/page")
    public ResponseEntity<List<AnimalBreedDTO>> getAnimalsBreedsPage(
            @Parameter(description = "Page number")
            @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
            @Parameter(description = "Count of items on page")
            @RequestParam(value = "size", defaultValue = "1") Integer size) {
        return ResponseEntity.ok(service.getAnimalsBreedsPage(pageNo, size));
    }

    @Operation(
            summary = "Update a breed of animal by ID",
            description = "For successfully updating animal breeds," +
                    " the animal type (ID) must be existed in base"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Breed updated or created (if breed ID still don't exist in DB)"),
            @ApiResponse(responseCode = "422",
                    description = "Duplicate unique animal breed name",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorResponseDTO.class))
                    })
    })
    @PutMapping
    public ResponseEntity updateBreed(@RequestBody AnimalBreedRequestPutDTO breedRequestDTO) {
        try {
            service.updateAnimalBreed(breedRequestDTO);
            return ResponseEntity.status(200).build();
        } catch (AnimalBreedNameDuplicateException e) {
            return ResponseEntity.status(422)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(new ErrorResponseDTO("Duplicate unique animal breed name",
                            "The name - " + breedRequestDTO.getName() +
                                    " already exists and cannot be repeated"));
        }
    }

    @Operation(
            summary = "Delete a breed of animal by ID",
            description = "Delete from DB MySQL"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete breed from DB")
    })
    @DeleteMapping("/{id}")
    public void deleteBreedById(@PathVariable(value = "id") Integer id) {
        service.deleteByID(id);
    }
}
