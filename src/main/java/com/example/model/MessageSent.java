package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "message_sent")
public class MessageSent extends BaseEntity {
    private Long number;

    public MessageSent() {
    }

    public MessageSent(Long id, Long number) {
        this.id = id;
        this.number = number;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
}
