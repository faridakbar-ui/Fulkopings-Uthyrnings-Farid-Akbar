package com.example.fulkoping.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Namn får inte vara tomt")
    private String name;

    @NotBlank(message = "Telefon får inte vara tomt")
    private String phone;
//en person kan vara kopplad till flera saker
    @ManyToMany
    @JoinTable(
            name = "person_thing",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "thing_id")
    )
    private Set<Thing> things = new HashSet<>();

    public Person() {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Thing> getThings() {
        return things;
    }

    public void setThings(Set<Thing> things) {
        this.things = things;
    }
}