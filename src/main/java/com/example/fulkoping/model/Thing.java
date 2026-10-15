package com.example.fulkoping.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Thing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Namn får inte vara tomt")
    private String name;

    @NotBlank(message = "Beskrivning får inte vara tom")
    private String description;
//sak kamn vara kopplad till flera personer
    @ManyToMany(mappedBy = "things")
    @JsonIgnore
    private Set<Person> persons = new HashSet<>();
    public Thing() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }
}