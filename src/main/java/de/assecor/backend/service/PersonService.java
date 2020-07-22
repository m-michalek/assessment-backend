package de.assecor.backend.service;

import de.assecor.backend.dao.PersonDao;
import de.assecor.backend.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonDao personDao;

    // Change @Qualifier decorator to switch data source
    // 1: CSV
    // 2: PostgreSQL
    // Check ../dao to see available db sources
    @Autowired
    public PersonService(@Qualifier("CSV") PersonDao personDao) {
        this.personDao = personDao;
    }

    public void addPerson(Person person) {
        personDao.insertPerson(person);
    }

    public List<Person> getAllPersons() {
        return personDao.selectAllPersons();
    }

    public Optional<Person> getPersonById(String id) {
        return personDao.selectPersonById(id);
    }

    public Optional<List<Person>> getPersonsByColor(String color) {
        return personDao.selectPersonsByColor(color);
    }
}
