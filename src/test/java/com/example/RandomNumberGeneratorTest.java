package com.example;

import com.example.model.MessageSent;
import com.example.repository.MessageSentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RandomNumberGeneratorTest {
    @Mock
    private RabbitTemplate rabbitTemplate;

    @Mock
    private MessageSentRepository messageSentRepository;

    @InjectMocks
    private RandomNumberGenerator randomNumberGenerator;

    @Captor
    private ArgumentCaptor<MessageSent> messageSentCaptor;

    @Test
    public void testRandomNumberGenerator() {
        MessageSent savedMessageSent = new MessageSent();
        savedMessageSent.setId(1L); // Mocked ID value
        when(messageSentRepository.save(any(MessageSent.class))).thenReturn(savedMessageSent);

        randomNumberGenerator.generateRandomNumber();

        verify(messageSentRepository).save(messageSentCaptor.capture());

        MessageSent capturedMessageSent = messageSentCaptor.getValue();

        long generatedRandomNumber = capturedMessageSent.getNumber();

        verify(rabbitTemplate).convertAndSend(
                eq(RabbitMQConfig.QUEUE_NAME),
                eq("{\"id\":1,\"number\":" + generatedRandomNumber + "}"));
    }
}
