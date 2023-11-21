package com.example.WorldOfAnimals.repositories;

import com.example.WorldOfAnimals.models.AnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository <AnimalEntity, Long> {

    @Query("SELECT animal FROM AnimalEntity animal " +
            "JOIN animal.animalBreedEntity breed " +
            "JOIN breed.type type " +
            "WHERE type.name = 'Dog'")
    List<AnimalEntity> getAllDogs();

    @Query("SELECT animal FROM AnimalEntity animal " +
            "JOIN animal.animalBreedEntity breed " +
            "JOIN breed.type type " +
            "WHERE type.name = 'Cat'")
    List<AnimalEntity> getAllCats();
}
