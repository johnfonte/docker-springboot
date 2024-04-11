package com.example.repository;

import com.example.model.MessageReceived;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageReceivedRepository extends JpaRepository<MessageReceived, Long> {
}
