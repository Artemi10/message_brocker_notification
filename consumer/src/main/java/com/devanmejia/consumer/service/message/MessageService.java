package com.devanmejia.consumer.service.message;

import com.devanmejia.consumer.transfer.request.UserDTO;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public interface MessageService {
    void sendLogInMessage(UserDTO user) throws MessagingException;
    void sendSignUpMessage(UserDTO user) throws MessagingException;
}
