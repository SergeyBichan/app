package ru.intervale.app.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.intervale.app.domain.Person;
import ru.intervale.app.domain.Type;
import ru.intervale.app.utils.Utility;

import java.util.Objects;

import static ru.intervale.app.domain.Type.FIZ;

@Service
public class RabbitMQProducer {
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Person person) {
        if (Objects.nonNull(person)){
            byte[] person2Bytes = Utility.serialize(person);
            LOGGER.info(String.format("Message sent -> %s", person));
            rabbitTemplate.convertAndSend(exchange, routingKey, person2Bytes);
        }
    }
}
