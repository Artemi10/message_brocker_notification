package com.devanmejia.producer.service.user;

import com.devanmejia.producer.transfer.request.LogInDTO;
import com.devanmejia.producer.transfer.request.SignUpDTO;
import com.devanmejia.producer.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User logIn(LogInDTO logInDTO);
    User signUp(SignUpDTO signUpDTO);
}
