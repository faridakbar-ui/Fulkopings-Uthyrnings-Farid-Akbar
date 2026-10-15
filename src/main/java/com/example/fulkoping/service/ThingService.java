package com.example.fulkoping.service;

import com.example.fulkoping.model.Person;
import com.example.fulkoping.model.Thing;
import com.example.fulkoping.repository.PersonRepository;
import com.example.fulkoping.repository.ThingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ThingService {

    private final ThingRepository thingRepository;
    private final PersonRepository personRepository;

    public ThingService(ThingRepository thingRepository,
                        PersonRepository personRepository) {
        this.thingRepository = thingRepository;
        this.personRepository = personRepository;
    }
//hämtar saker från databasen
    public List<Thing> getAll() {
        return thingRepository.findAll();
    }

    public Thing getById(Long id) {
        return thingRepository.findById(id)
                .orElseThrow();
    }

    public Thing save(Thing thing) {
        return thingRepository.save(thing);
    }
//uppdaterar namnet och beskrivningen
    public Thing update(Long id, Thing thing) {
        Thing existing = getById(id);
        existing.setName(thing.getName());
        existing.setDescription(thing.getDescription());
        return thingRepository.save(existing);
    }
//tar bort kopplingen innan sak raderas
    @Transactional
    public void delete(Long id) {
        Thing thing = getById(id);

        List<Person> persons = personRepository.findAll();

        for (Person person : persons) {
            person.getThings().removeIf(
                    item -> item.getId().equals(id)
            );
        }

        personRepository.saveAll(persons);
        thingRepository.delete(thing);
    }
}