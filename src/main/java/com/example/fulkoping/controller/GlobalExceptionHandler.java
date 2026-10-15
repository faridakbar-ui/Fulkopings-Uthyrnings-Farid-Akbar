package com.example.fulkoping.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.NoSuchElementException;
//för hela api
@RestControllerAdvice
public class GlobalExceptionHandler {
//404 om person eller sak inte hittas
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Map<String, String>> handleNotFound(
            NoSuchElementException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", "hittades inte"));
    }
//400 om valideringen blir fel
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(
            MethodArgumentNotValidException ex) {

        return ResponseEntity.badRequest()
                .body(Map.of("error", "Kontrollera att alla fält är fyllda"));
    }
}

