package com.samark.api;

import com.samark.Model.Person;
import com.samark.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@Valid @NotNull @RequestBody Person person) {
        this.personService.insertPerson(person);
    }

    @GetMapping
    public List<Person> getAllPerson() {
        return this.personService.getAllPerson();
    }

    @GetMapping("/{id}")
    public Person findPersonById(@PathVariable("id") UUID id) {
        return this.personService.findPersonByid(id);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id") UUID id) {
        this.personService.deletePersonById(id);
    }

    @PutMapping("/{id}")
    public void updatePersonById(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Person person) {
        this.personService.updatePersonById(id, person);
    }
}
