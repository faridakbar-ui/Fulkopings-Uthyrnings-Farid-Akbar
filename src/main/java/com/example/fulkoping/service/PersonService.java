package com.example.fulkoping.service;

import com.example.fulkoping.model.Person;
import com.example.fulkoping.model.Thing;
import com.example.fulkoping.repository.PersonRepository;
import com.example.fulkoping.repository.ThingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final ThingRepository thingRepository;

    public PersonService(PersonRepository personRepository,
                         ThingRepository thingRepository) {
        this.personRepository = personRepository;
        this.thingRepository = thingRepository;
    }
//hämtar person från databas
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person getById(Long id) {
        return personRepository.findById(id)
                .orElseThrow();
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }
//uppdaterar namn och nummer
    public Person update(Long id, Person person) {
        Person existing = getById(id);
        existing.setName(person.getName());
        existing.setPhone(person.getPhone());
        return personRepository.save(existing);
    }

    public Person addThing(Long personId, Long thingId) {
        Person person = personRepository.findById(personId)
                .orElseThrow();

        Thing thing = thingRepository.findById(thingId)
                .orElseThrow();

        person.getThings().add(thing);

        return personRepository.save(person);
    }

    public void delete(Long id) {
        Person person = getById(id);
        person.getThings().clear();
        personRepository.save(person);
        personRepository.delete(person);
    }
}