package com.example.WorldOfAnimals.services;

import com.example.WorldOfAnimals.exceptions.AnimalImageNotFoundException;
import com.example.WorldOfAnimals.exceptions.AnimalNotFoundException;
import com.example.WorldOfAnimals.models.AnimalEntity;
import com.example.WorldOfAnimals.models.AnimalImageEntity;
import com.example.WorldOfAnimals.repositories.AnimalImageRepository;
import com.example.WorldOfAnimals.repositories.AnimalRepository;
import com.example.WorldOfAnimals.utils.Constants;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;

@Service
@AllArgsConstructor
public class AnimalImageService {

    private final AnimalRepository animalRepository;
    private final AnimalImageRepository animalImageRepository;

    @Transactional
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

    public Resource getAnimalImageById(Long id) {
        AnimalImageEntity animalImageEntity = animalImageRepository.findById(id).orElseThrow(() ->
                new AnimalImageNotFoundException("Animal image with ID " + id + " not found!"));
        String path = animalImageEntity.getFilePath();
        Resource resource = null;
        try {
            resource = new UrlResource(Paths.get(path).toUri());
            return resource;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    public void deleteAnimalById(Long id) {
        AnimalImageEntity animalImageEntity = animalImageRepository.findById(id).orElseThrow(() ->
                new AnimalImageNotFoundException("Animal image with ID " + id + " not found!"));
        try {
            Files.deleteIfExists(Paths.get(animalImageEntity.getFilePath()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        animalImageRepository.deleteById(id);
    }
}
