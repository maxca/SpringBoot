package com.samark.Service;

import com.samark.Dao.PersonDao;
import com.samark.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("mysql") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int insertPerson(Person person) {
        return this.personDao.insertPerson(person);
    }

    public List<Person> getAllPerson() {
        return this.personDao.getAlLPerson();
    }

    public Person findPersonByid(UUID id) {
        return this.personDao.findPersonById(id)
                .orElse(null);
    }

    public int deletePersonById(UUID id) {
        return this.personDao.deletePersonById(id);
    }

    public int updatePersonById(UUID id, Person person) {
        return this.personDao.updatePersonById(id, person);
    }


}
