package com.example.fulkoping.controller;

import com.example.fulkoping.model.Person;
import com.example.fulkoping.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//tar emot http anrop från postman
@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getAll() {
        return personService.getAll();
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable Long id) {
        return personService.getById(id);
    }
//omvnadlar json och kortollerar anrop
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person create(@Valid @RequestBody Person person) {
        return personService.save(person);
    }

    @PutMapping("/{id}")
    public Person update(@PathVariable Long id,
                         @Valid @RequestBody Person person) {
        return personService.update(id, person);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        personService.delete(id);
    }
    @PutMapping("/{personId}/things/{thingId}")
    public Person addThing(@PathVariable Long personId,
                           @PathVariable Long thingId) {
        return personService.addThing(personId, thingId);
    }
}

