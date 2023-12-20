package com.example.WorldOfAnimals.utils;

import com.example.WorldOfAnimals.models.AnimalEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class AnimalSpecification implements Specification<AnimalEntity> {
    private final AnimalFilter filter;

    @Override
    public Predicate toPredicate(Root<AnimalEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.equal(root.get("age"), filter.getAge()));
        predicates.add(criteriaBuilder.equal(root.get("animalBreedEntity")
                .get("type").get("name"), filter.getAnimalTypeName()));

        if (filter.getAnimalBreedName() != null && !filter.getAnimalBreedName().isEmpty()) {
            predicates.add(criteriaBuilder.equal(root.get("animalBreedEntity")
                    .get("name"), filter.getAnimalBreedName()));
        }

        predicates.add(criteriaBuilder.equal(root.get("sex"), filter.getSex()));
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
