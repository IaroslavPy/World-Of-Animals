package com.example.WorldOfAnimals.repositories;

import com.example.WorldOfAnimals.models.AnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface AnimalRepository extends JpaRepository <AnimalEntity, Long>,
         JpaSpecificationExecutor<AnimalEntity> {
}
