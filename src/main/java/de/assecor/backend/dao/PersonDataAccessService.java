package de.assecor.backend.dao;

import de.assecor.backend.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

// name of new db identifier
@Repository("PostgreSQL")
public class PersonDataAccessService implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertPerson(Person person) {
        String sql = "" +
                "INSERT INTO person (" +
                " id, " +
                " name, " +
                " lastName, " +
                " zipcode, " +
                " city, " +
                " color) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                // TODO: Refactor id generation to real UUID
                String.valueOf(ThreadLocalRandom.current().nextInt(12, 100 + 1)),
                person.getName(),
                person.getLastName(),
                person.getZipcode(),
                person.getCity(),
                person.getColor()
        );
    }

    @Override
    public List<Person> selectAllPersons() {
        final String sql = "SELECT id, name, lastName, zipcode, city, color FROM person";
        return jdbcTemplate.query(sql, (resultSet, i) -> {

            // When switching from id type String to UUID don't forget to convert the String to type UUID here
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String lastName = resultSet.getString("lastName");
            String zipcode = resultSet.getString("zipcode");
            String city = resultSet.getString("city");
            String color = resultSet.getString("color");

            return new Person(id, name, lastName, zipcode, city, color);
        });
    }

    @Override
    public Optional<Person> selectPersonById(String id) {

        final String sql = "SELECT id, name, lastName, zipcode, city, color FROM person WHERE id = ?";

        Person person = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {

            // When switching from id type String to UUID don't forget to convert the String to type UUID here
            String personId = resultSet.getString("id");
            String name = resultSet.getString("name");
            String lastName = resultSet.getString("lastName");
            String zipcode = resultSet.getString("zipcode");
            String city = resultSet.getString("city");
            String color = resultSet.getString("color");

            return new Person(personId, name, lastName, zipcode, city, color);
        });

        return Optional.ofNullable(person);
    }

    @Override
    public Optional<List<Person>> selectPersonsByColor(String color) {

        final String sql = "SELECT id, name, lastName, zipcode, city, color FROM person WHERE color = ?";
        List<Person> persons = jdbcTemplate.query(sql, new Object[]{color}, (resultSet, i) -> {

            // When switching from id type String to UUID don't forget to convert the String to type UUID here
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String lastName = resultSet.getString("lastName");
            String zipcode = resultSet.getString("zipcode");
            String city = resultSet.getString("city");
            String peronColor = resultSet.getString("color");

            return new Person(id, name, lastName, zipcode, city, peronColor);
        });

        return Optional.ofNullable(persons);
    }
}
