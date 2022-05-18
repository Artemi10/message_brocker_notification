package com.devanmejia.producer.repository;

import com.devanmejia.producer.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, Long> {
    @Query("{ 'email' : ?0 }")
    Optional<User> findByEmail(String email);
}
