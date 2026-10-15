package com.example.fulkoping.controller;

import com.example.fulkoping.model.Thing;
import com.example.fulkoping.service.ThingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/things")
public class ThingController {

    private final ThingService thingService;

    public ThingController(ThingService thingService) {
        this.thingService = thingService;
    }
//hämtar data från databasen
    @GetMapping
    public List<Thing> getAll() {
        return thingService.getAll();
    }

    @GetMapping("/{id}")
    public Thing getById(@PathVariable Long id) {
        return thingService.getById(id);
    }
//skapar saken
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Thing create(@Valid @RequestBody Thing thing) {
        return thingService.save(thing);
    }

    @PutMapping("/{id}")
    public Thing update(@PathVariable Long id,
                        @Valid @RequestBody Thing thing) {
        return thingService.update(id, thing);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        thingService.delete(id);
    }
}

