package com.example.WorldOfAnimals.controllers;

import com.example.WorldOfAnimals.dto.AnimalDTO;
import com.example.WorldOfAnimals.dto.AnimalImageRequestDTO;
import com.example.WorldOfAnimals.dto.AnimalImageRequestPutDTO;
import com.example.WorldOfAnimals.exceptions.AnimalImageNotFoundException;
import com.example.WorldOfAnimals.services.AnimalImageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Tag(
        name = "Animal images",
        description = "Manage animal images by define (existed in base) animal"
)
@RestController
@RequestMapping("/animal/images")
@AllArgsConstructor
public class AnimalImageController {

    private final AnimalImageService service;

    @Operation(
            summary = "Create (upload) new animal image",
            description = "For successfully creating (uploading) animal image (max size - 50 Mb)," +
                    " the animal must be existed in base.\\\n Curl example (correct):\\\n" +
                    "curl --silent --location --request POST 'http://localhost:9721/animal/images' \\\n" +
                    "--form 'file=@\"nLLaUeL60/_48.JPG\"' \\\n" +
                    "--form 'request=\"{\n" +
                    "\\\"animalId\\\": 1\n" +
                    "}\";type=application/json' \\\n" +
                    "Swagger creates incorrect headers by default in this case."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Image uploaded")
    })
    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public void uploadAnimalImage(
            @Parameter(description = "Existed ID (animal)")
            @RequestPart @Valid @NonNull AnimalImageRequestDTO request,
            @Parameter(description = "50 Mb - max file size")
            @RequestPart @NonNull MultipartFile file) {
        service.uploadAnimalImage(request, file);
    }

    @Operation(
            summary = "Retrieve (download) an animal image by ID",
            description = "Download image to your PC (max size - 50 Mb)"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retrieve an animal image by ID",
                    content = {
                            @Content(mediaType = "image/jpeg",
                                    schema = @Schema(implementation = AnimalDTO.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Animal not found")
    })
    @GetMapping(value = "/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<Resource> getAnimalImageById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(service.getAnimalImageById(id));
        } catch (AnimalImageNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(
            summary = "Update (upload) an animal image by ID",
            description = "For successfully updating (uploading)" +
                    " an animal image (50 Mb - max file size)," +
                    " the the animal image must be existed in base. " +
                    "\\\n Curl example (correct):\\\n" +
                    "curl --silent --location --request PUT 'http://localhost:9721/animal/images' \\\n" +
                    "--form 'file=@\"Eko8crIL1/heli_004.jpg\"' \\\n" +
                    "--form 'request=\"{\\\"animalImageId\\\": 1\n" +
                    "}\";type=application/json'\\\n" +
                    "Swagger creates incorrect headers by default in this case."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Animal image updated"),
            @ApiResponse(responseCode = "404", description = "Animal image for updating not found")
    })
    @PutMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity updateAnimalImage(
            @Parameter(description = "Existed ID (animal)")
            @RequestPart @Valid @NonNull AnimalImageRequestPutDTO request,
            @Parameter(description = "50 Mb - max file size")
            @RequestPart @NonNull MultipartFile file) {
        try {
            service.updateAnimalImage(file, request);
            return ResponseEntity.ok().build();
        } catch (AnimalImageNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(
            summary = "Delete an animal images by ID",
            description = "Delete from DB MySQL and Data Storage (image)"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete image"),
            @ApiResponse(responseCode = "404", description = "Image not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity deleteAnimalImageById(@PathVariable(value = "id") Long id) {
        try {
            service.deleteAnimalImageById(id);
            return ResponseEntity.ok().build();
        } catch (AnimalImageNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
