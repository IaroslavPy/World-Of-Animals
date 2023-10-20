package com.example.WorldOfAnimals.controllers;

import com.example.WorldOfAnimals.dto.AnimalImageRequestDTO;
import com.example.WorldOfAnimals.exceptions.AnimalImageNotFoundException;
import com.example.WorldOfAnimals.services.AnimalImageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
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
            description = "For successfully creating (uploading) animal image," +
                    " the animal must be existed in base"
    )
    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @ResponseStatus(HttpStatus.OK)
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
            description = "For successfully updating (uploading) an animal image ," +
                    " the animal and the animal image must be existed in base. " +
                    "50 Mb - max file size"
    )
    @PutMapping("/{id}")
    public ResponseEntity updateAnimalImage(
            @RequestParam("file") MultipartFile multipartFile,
            @PathVariable("id") Long id) {
        try {
            service.updateAnimalImage(multipartFile, id);
            return ResponseEntity.ok().build();
        } catch (AnimalImageNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(
            summary = "Delete an animal images by ID",
            description = "Delete from DB MySQL and Data Storage (image)"
    )
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
