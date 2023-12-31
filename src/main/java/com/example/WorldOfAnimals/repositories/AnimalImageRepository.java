package com.example.WorldOfAnimals.repositories;

import com.example.WorldOfAnimals.models.AnimalImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalImageRepository extends JpaRepository<AnimalImageEntity, Long> {
}
