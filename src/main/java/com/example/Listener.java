package com.example;

import com.example.model.MessageReceived;
import com.example.repository.MessageReceivedRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class Listener {
    private final MessageReceivedRepository messageReceivedRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public Listener(MessageReceivedRepository messageReceivedRepository, ObjectMapper objectMapper) {
        this.messageReceivedRepository = messageReceivedRepository;
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receiveMessage(String message) {
        try {
            Map<String, Object> jsonMap = objectMapper.readValue(message, new TypeReference<Map<String,Object>>(){});

            int id = (int) jsonMap.get("id");
            int number = (int) jsonMap.get("number");
            int result = number * 2;

            MessageReceived messageReceived = new MessageReceived((long) id, (long) result);
            messageReceivedRepository.save(messageReceived);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
