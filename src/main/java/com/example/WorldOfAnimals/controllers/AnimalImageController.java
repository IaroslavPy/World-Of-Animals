package com.example.WorldOfAnimals.controllers;

import com.example.WorldOfAnimals.exceptions.AnimalImageNotFoundException;
import com.example.WorldOfAnimals.services.AnimalImageService;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/animals/images")
@AllArgsConstructor
public class AnimalImageController {

    private final AnimalImageService service;

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public void uploadAnimalImage(
            @RequestParam("file") @NonNull MultipartFile file,
            @RequestParam("request") @NonNull String request) {
        service.uploadAnimalImage(request, file);
    }

    @GetMapping(value = "/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<Resource> getAnimalImageById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(service.getAnimalImageById(id));
        } catch (AnimalImageNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateAnimalImage(@RequestParam("file") MultipartFile multipartFile,
                                            @PathVariable("id") Long id) {
        try {
            service.updateAnimalImage(multipartFile, id);
            return ResponseEntity.ok().build();
        } catch (AnimalImageNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

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
