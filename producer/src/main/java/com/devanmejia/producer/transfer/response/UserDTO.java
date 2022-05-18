package com.devanmejia.producer.transfer.response;

import com.devanmejia.producer.model.User;

public record UserDTO(String email, String password) {
    public UserDTO(User user) {
        this(user.getEmail(), user.getPassword());
    }
}
