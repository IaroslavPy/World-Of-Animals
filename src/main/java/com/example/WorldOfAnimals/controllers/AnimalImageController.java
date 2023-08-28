package com.example.WorldOfAnimals.controllers;

import com.example.WorldOfAnimals.services.AnimalImageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/upload")
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadImage(@RequestParam("file")MultipartFile multipartFile){
        service.uploadImage(multipartFile);
    }
}
