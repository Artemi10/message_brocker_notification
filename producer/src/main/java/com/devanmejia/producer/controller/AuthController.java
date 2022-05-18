package com.devanmejia.producer.controller;

import com.devanmejia.producer.transfer.request.LogInDTO;
import com.devanmejia.producer.transfer.request.SignUpDTO;
import com.devanmejia.producer.transfer.response.UserDTO;
import com.devanmejia.producer.service.sender.MessageSender;
import com.devanmejia.producer.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final UserService userService;
    private final MessageSender messageSender;

    @PostMapping("/log-in")
    public void logIn(@RequestBody LogInDTO logInDTO) {
        var user = userService.logIn(logInDTO);
        messageSender.sendLogInMessage(new UserDTO(user));
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody SignUpDTO signUpDTO) {
        var user = userService.signUp(signUpDTO);
        messageSender.sendSignUpMessage(new UserDTO(user));
    }
}
