package com.example.WorldOfAnimals.exceptions;

public class AnimalTypeNameDuplicateException extends RuntimeException{
    public AnimalTypeNameDuplicateException(String message) {
        super(message);
    }
}
