package com.devanmejia.consumer.service.stat;

import com.devanmejia.consumer.model.Stat;
import com.devanmejia.consumer.repository.StatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StatServiceImpl implements StatService {
    private final StatRepository statRepository;

    @Override
    public void addNotification(String email) {
        var statOptional = statRepository.findByEmail(email);
        Stat stat;
        if (statOptional.isPresent()) {
            stat = statOptional.get();
            stat.incrementNotifications();
        }
        else {
            stat = Stat.empty(email);
        }
        statRepository.save(stat);
    }

    @Override
    public Stat getStatByEmail(String email) {
        return statRepository.findByEmail(email)
                .orElse(Stat.empty(email));
    }

    @Override
    public List<Stat> getAllStats() {
        return statRepository.findAll();
    }
}
