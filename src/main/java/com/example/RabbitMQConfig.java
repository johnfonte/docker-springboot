package com.example;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "mn-queue";

    @Bean
    public Queue myQueue() {
        return new Queue(QUEUE_NAME);
    }
}
