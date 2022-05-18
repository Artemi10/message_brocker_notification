package com.devanmejia.consumer.repository;

import com.devanmejia.consumer.model.Stat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface StatRepository extends MongoRepository<Stat, String> {

    @Query("{ 'email' : ?0 }")
    Optional<Stat> findByEmail(String email);
}
