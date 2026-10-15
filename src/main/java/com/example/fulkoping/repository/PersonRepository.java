package com.example.fulkoping.repository;

import com.example.fulkoping.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
//pratar med databasen
//jpa färdiga metoder
public interface PersonRepository extends JpaRepository<Person, Long> {
}