package com.devanmejia.consumer.service.stat;

import com.devanmejia.consumer.model.Stat;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StatService {
    void addNotification(String email);
    Stat getStatByEmail(String email);
    List<Stat> getAllStats();
}
