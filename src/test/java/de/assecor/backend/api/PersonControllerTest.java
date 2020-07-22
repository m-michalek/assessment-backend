package de.assecor.backend.api;

import de.assecor.backend.dao.PersonDao;
import de.assecor.backend.model.Person;
import de.assecor.backend.service.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PersonController.class)
class PersonControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test()
    void addPerson() {
        /**
        RequestBuilder request = MockMvcRequestBuilders.post("/persons",
                new Person(
                        "22",
                        "Jon",
                        "Doe",
                        "10101",
                        "Berlin",
                        "gray"
                )
        );
        MvcResult result = mvc.perform(request).andReturn();

        assertEquals(200, result.getResponse().getStatus());
        **/
    }

    @Test
    void getAllPersons() throws Exception {
        /**
        RequestBuilder request = MockMvcRequestBuilders.get("/persons");
        MvcResult result = mvc.perform(request).andReturn();

        assertEquals(200, result.getResponse().getStatus());
         **/
    }

    @Test
    void getPersonById() {
        /**
        RequestBuilder request = MockMvcRequestBuilders.get("/persons/1").characterEncoding("utf-8");
        MvcResult result = mvc.perform(request).andReturn();

        String except = "{\"id\":\"1\",\"name\":\"Hans\",\"lastName\":\"Müller\",\"zipcode\":\"67742\",\"city\":\"Lauterecken\",\"color\":\"blau\"}";

        assertEquals(200, result.getResponse().getStatus());
        assertEquals(except, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
         **/
    }

    @Test
    void getPersonsByColor() {
        /**
        RequestBuilder request = MockMvcRequestBuilders.get("/persons/color/grün").characterEncoding("utf-8");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals(200, result.getResponse().getStatus());

        String except = "[{\"id\":\"2\",\"name\":\"Peter\",\"lastName\":\"Petersen\",\"zipcode\":\"18439\",\"city\":\"Stralsund\",\"color\":\"grün\"},{\"id\":\"7\",\"name\":\"Anders\",\"lastName\":\"Andersson\",\"zipcode\":\"32132\",\"city\":\"Schweden - ☀\",\"color\":\"grün\"},{\"id\":\"10\",\"name\":\"Klaus\",\"lastName\":\"Klaussen\",\"zipcode\":\"43246\",\"city\":\"Hierach\",\"color\":\"grün\"}]";

        assertEquals(200, result.getResponse().getStatus());
        assertEquals(except, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
         **/
    }
}