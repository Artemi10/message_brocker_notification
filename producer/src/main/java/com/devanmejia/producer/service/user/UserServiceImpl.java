package com.devanmejia.producer.service.user;

import com.devanmejia.producer.transfer.request.LogInDTO;
import com.devanmejia.producer.transfer.request.SignUpDTO;
import com.devanmejia.producer.model.User;
import com.devanmejia.producer.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User logIn(LogInDTO logInDTO) {
        return userRepository.findByEmail(logInDTO.email())
                .filter(user -> user.getPassword().equals(logInDTO.password()))
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    @Override
    public User signUp(SignUpDTO signUpDTO) {
        var userCandidate = userRepository.findByEmail(signUpDTO.email());
        if (userCandidate.isEmpty()) {
            var user = User.builder()
                    .email(signUpDTO.email())
                    .password(signUpDTO.password())
                    .gender(signUpDTO.gender())
                    .build();
            return userRepository.save(user);
        }
        else throw new IllegalArgumentException("User has already been registered");
    }
}
