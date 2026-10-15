package com.example.fulkoping.repository;

import com.example.fulkoping.model.Thing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThingRepository extends JpaRepository<Thing, Long> {
}