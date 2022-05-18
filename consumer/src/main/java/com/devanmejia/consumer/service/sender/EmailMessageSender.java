package com.devanmejia.consumer.service.sender;

import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;

@Service
public class EmailMessageSender implements MessageSender {
    @Override
    public void send(Message message) throws MessagingException {
        try {
            Thread.sleep(20_000);
            Transport.send(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
