package com.example.repository;

import com.example.model.MessageSent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageSentRepository extends JpaRepository<MessageSent, Long> {
}
