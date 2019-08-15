package com.samark.Dao;

import com.samark.Model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("mysql")
public class PersonDataService implements PersonDao {
    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> getAlLPerson() {
        return List.of(new Person(UUID.randomUUID(), "Person form Mysql"));
    }

    @Override
    public Optional<Person> findPersonById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }
}
