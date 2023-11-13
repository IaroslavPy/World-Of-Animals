package com.example.WorldOfAnimals.advices;

import com.example.WorldOfAnimals.dto.ErrorResponseDTO;
import com.example.WorldOfAnimals.exceptions.AnimalImageNotFoundException;
import com.example.WorldOfAnimals.exceptions.AnimalNotFoundException;
import com.example.WorldOfAnimals.exceptions.AnimalTypeNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomAdvice {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponseDTO> handleDuplicateNameException(DataIntegrityViolationException e) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO("Bad request", e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({AnimalTypeNotFoundException.class,
            AnimalImageNotFoundException.class, AnimalNotFoundException.class})
    public ResponseEntity<ErrorResponseDTO> handleNotFoundException(RuntimeException e) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO("Entity not found", e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
