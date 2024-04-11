package com.example;

import com.example.model.MessageSent;
import com.example.repository.MessageSentRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class RandomNumberGenerator {

    private final RabbitTemplate rabbitTemplate;
    private final MessageSentRepository messageSentRepository;

    public RandomNumberGenerator(
            RabbitTemplate rabbitTemplate,
            MessageSentRepository messageSentRepository
    ) {
        this.rabbitTemplate = rabbitTemplate;
        this.messageSentRepository = messageSentRepository;
    }

    @Scheduled(fixedRate = 10000) // 10 seconds
    public void generateRandomNumber() {
        int randomNumber = ThreadLocalRandom.current().nextInt(100);
        MessageSent messageSent = new MessageSent();
        messageSent.setNumber((long) randomNumber);
        messageSent = messageSentRepository.save(messageSent);

        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, "{\"id\":" + messageSent.getId() + ",\"number\":" + randomNumber + "}");
    }
}
