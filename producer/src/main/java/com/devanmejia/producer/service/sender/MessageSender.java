package com.devanmejia.producer.service.sender;

import com.devanmejia.producer.transfer.response.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface MessageSender {
    void sendLogInMessage(UserDTO userDTO);
    void sendSignUpMessage(UserDTO userDTO);
}
