package com.example.WorldOfAnimals.services;

import com.example.WorldOfAnimals.exceptions.AnimalNotFoundException;
import com.example.WorldOfAnimals.models.AnimalEntity;
import com.example.WorldOfAnimals.models.AnimalImageEntity;
import com.example.WorldOfAnimals.repositories.AnimalImageRepository;
import com.example.WorldOfAnimals.repositories.AnimalRepository;
import com.example.WorldOfAnimals.utils.Constants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;

@Service
@AllArgsConstructor
public class AnimalImageService {

    private final AnimalRepository animalRepository;
    private final AnimalImageRepository animalImageRepository;

    public void uploadImage(MultipartFile multipartFile) {
        try {
            Files.copy(multipartFile.getInputStream(), Paths.get(Constants.UPLOAD_IMAGES_PATH +
                    multipartFile.getOriginalFilename()));

            Long exampleId = 1L;
            AnimalEntity exampleAnimal = animalRepository.findById(exampleId).orElseThrow(() ->
                    new AnimalNotFoundException("Animal with ID " +
                            exampleId + " not found!"));

            AnimalImageEntity animalImage = new AnimalImageEntity()
                    .setAnimal(exampleAnimal)
                    .setFilePath(Constants.UPLOAD_IMAGES_PATH + multipartFile.getOriginalFilename())
                    .setFileType(multipartFile.getContentType().substring(6))
                    .setFileSize(multipartFile.getSize())
                    .setCreated(new Timestamp(System.currentTimeMillis()))
                    .setUpdated(new Timestamp(System.currentTimeMillis()));

            try {
                animalImageRepository.save(animalImage);
            } catch (RuntimeException e) {
                try {
                    Files.deleteIfExists(Paths.get(animalImage.getFilePath()));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
