package com.devanmejia.consumer.service.sender;

import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;

@Service
public interface MessageSender {
    void send(Message message) throws MessagingException;
}
