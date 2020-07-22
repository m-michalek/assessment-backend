package de.assecor.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    private final String id;
    private final String name;
    private final String lastName;
    private final String zipcode;
    private final String city;
    private final String color;

    public Person(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("zipcode") String zipcode,
            @JsonProperty("city") String city,
            @JsonProperty("color") String color
    ) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.zipcode = zipcode;
        this.city = city;
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    public String getColor() {
        return color;
    }
}
