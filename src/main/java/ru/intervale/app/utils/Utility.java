package ru.intervale.app.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.intervale.app.domain.Person;

import java.io.IOException;

public class Utility {
    public static byte[] serialize(Person person) {
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            return objectMapper.writeValueAsBytes(person);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Person deserialize(byte[] data) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(data, Person.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
