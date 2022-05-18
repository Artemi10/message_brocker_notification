package com.devanmejia.producer.service.sender;

import com.devanmejia.producer.transfer.response.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailMessageSender implements MessageSender {
    private final RabbitTemplate rabbitTemplate;

    @Override
    public void sendLogInMessage(UserDTO userDTO) {
        rabbitTemplate.convertAndSend("q.log-in-notification", userDTO);
    }

    @Override
    public void sendSignUpMessage(UserDTO userDTO) {
        rabbitTemplate.convertAndSend("q.sign-up-notification", userDTO);
    }
}
