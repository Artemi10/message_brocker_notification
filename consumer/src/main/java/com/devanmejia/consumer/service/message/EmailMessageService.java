package com.devanmejia.consumer.service.message;

import com.devanmejia.consumer.transfer.request.UserDTO;
import com.devanmejia.consumer.service.sender.MessageSender;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;

@Service
@AllArgsConstructor
public class EmailMessageService implements MessageService {
    private final MessageSender sender;

    @Override
    public void sendLogInMessage(UserDTO user) throws MessagingException {
        var message = emailMessage();
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(user.email()));
        message.setSubject("Log In Event");
        message.setText("Logged in successfully with password " + user.password());
        sender.send(message);
    }

    @Override
    public void sendSignUpMessage(UserDTO user) throws MessagingException {
        var message = emailMessage();
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(user.email()));
        message.setSubject("Sign Up Event");
        message.setText("Signed up successfully with password " + user.password());
        sender.send(message);
    }

    @Lookup
    protected Message emailMessage(){
        return null;
    }

}
