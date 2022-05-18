package com.devanmejia.producer.transfer.request;

import com.devanmejia.producer.model.Gender;

public record SignUpDTO (String email, String password, Gender gender){
}
