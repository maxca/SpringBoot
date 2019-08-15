package com.samark.Dao;

import com.samark.Model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("FakeDao")
public class PersonDataAccessService implements PersonDao {
    @Override
    public Optional<Person> findPersonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int updatePersonById(UUID id, Person update) {
        return findPersonById(id)
                .map(person -> {
                    int indexOfUpdateItem = DB.indexOf(person);
                    if (indexOfUpdateItem >= 0) {
                        DB.set(indexOfUpdateItem, new Person(id, update.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personMayBe = findPersonById(id);
        if (personMayBe.isEmpty()) {
            return 0;
        }
        DB.remove(personMayBe.get());
        return 1;
    }

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> getAlLPerson() {
        return DB;
    }

}
