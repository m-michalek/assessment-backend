package de.assecor.backend.dao;

import de.assecor.backend.datascource.CsvDatasource;
import de.assecor.backend.model.Person;
import de.assecor.backend.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Repository("CSV")
public class CsvPersonDataAccess implements PersonDao {

// TODO: Fix dependency injection of csvDatasource

//    private static CsvDatasource csvDatasource;

//    @Autowired
//    public CsvPersonDataAccess(CsvDatasource csvDatasource) {
//        this.csvDatasource = csvDatasource;
//    }

//    private static List<Person> DB = csvDatasource.readCsv();

    private static CsvDatasource csvDatasource = new CsvDatasource();

    private static List<Person> DB = csvDatasource.readCsv();



    @Override
    public void insertPerson(Person person) {
        DB.add(new Person(
                // TODO: Refactor id generation to real UUID
                String.valueOf(ThreadLocalRandom.current().nextInt(12, 100 + 1)),
                person.getName(),
                person.getLastName(),
                person.getZipcode(),
                person.getCity(),
                person.getColor()
                )
        );
    }

    @Override
    public List<Person> selectAllPersons() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(String id) {
        return Optional.ofNullable(
                DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst()
                .orElse(null)
        );
    }

    @Override
    public Optional<List<Person>> selectPersonsByColor(String color) {
        return Optional.of(
                DB.stream()
                        .filter(person -> person.getColor().equals(color))
                        .collect(Collectors.toList())
        );
    }

}
