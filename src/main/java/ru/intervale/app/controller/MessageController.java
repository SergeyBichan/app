package ru.intervale.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.intervale.app.domain.Person;
import ru.intervale.app.publisher.RabbitMQProducer;

@RestController
public class MessageController {
    private final RabbitMQProducer producer;

    public MessageController(RabbitMQProducer producer) {
        this.producer = producer;
    }


    @PostMapping("/person")
    public ResponseEntity<String> sendPerson(@RequestBody Person person){
        producer.sendMessage(person);
        return ResponseEntity.ok("Message sent to RabbitMQ ...");
    }
}
