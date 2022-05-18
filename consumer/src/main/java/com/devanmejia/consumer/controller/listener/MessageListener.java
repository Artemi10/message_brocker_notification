package com.devanmejia.consumer.controller.listener;

import com.devanmejia.consumer.service.stat.StatService;
import com.devanmejia.consumer.transfer.request.UserDTO;
import com.devanmejia.consumer.service.message.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
@AllArgsConstructor
public class MessageListener {
    private final StatService statService;
    private final MessageService messageService;

    @RabbitListener(queues = {"q.log-in-notification"})
    public void sendLogInMessage(UserDTO userDTO) throws MessagingException {
        messageService.sendLogInMessage(userDTO);
        statService.addNotification(userDTO.email());
    }

    @RabbitListener(queues = {"q.sign-up-notification"})
    public void sendSignUpMessage(UserDTO userDTO) throws MessagingException {
        messageService.sendSignUpMessage(userDTO);
        statService.addNotification(userDTO.email());
    }
}
