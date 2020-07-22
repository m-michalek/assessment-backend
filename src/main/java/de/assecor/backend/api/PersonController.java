package de.assecor.backend.api;

import de.assecor.backend.model.Person;
import de.assecor.backend.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {

        // Get list of persons
        List<Person> persons = personService.getAllPersons();

        // Check if list of persons is empty and return HTTP response code 404
        if(persons.isEmpty()) {
            return new ResponseEntity<List<Person>>(HttpStatus.NOT_FOUND);
        }

        // Return list of persons and HTTP response code 200
        return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Person>> getPersonById(@PathVariable("id") String id) {

        // Get matching person
        Optional<Person> person = personService.getPersonById(id);

        // Check if person is null and return HTTP response code 404
        if(person.isEmpty()) {
            return new ResponseEntity<Optional<Person>>(HttpStatus.NOT_FOUND);
        }

        // Return person and HTTP response code 200
        return new ResponseEntity<Optional<Person>>(person, HttpStatus.OK);
    }

    @GetMapping("/color/{color}")
    public ResponseEntity<Optional<List<Person>>> getPersonsByColor(@PathVariable("color") String color) {

        // Get matching person
        Optional<List<Person>> person = personService.getPersonsByColor(color);

        // Check if person is null and return HTTP response code 404
        if(person.isEmpty()) {
            return new ResponseEntity<Optional<List<Person>>>(HttpStatus.NOT_FOUND);
        }

        // Return person and HTTP response code 200
        return new ResponseEntity<Optional<List<Person>>>(person, HttpStatus.OK);
    }
}
