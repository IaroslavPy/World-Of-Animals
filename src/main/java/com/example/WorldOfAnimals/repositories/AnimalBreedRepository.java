package com.example.WorldOfAnimals.repositories;

import com.example.WorldOfAnimals.models.AnimalBreedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalBreedRepository extends JpaRepository<AnimalBreedEntity, Integer> {

    
}
