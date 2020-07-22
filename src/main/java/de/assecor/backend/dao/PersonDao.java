package de.assecor.backend.dao;

import de.assecor.backend.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonDao {

    void insertPerson(Person person);

    List<Person> selectAllPersons();

    Optional<Person> selectPersonById(String id);

    Optional<List<Person>> selectPersonsByColor(String color);
}
