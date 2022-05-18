package com.devanmejia.consumer.transfer.response;

import com.devanmejia.consumer.model.Stat;

public record StatDTO(String email, long notificationAmount) {
    public StatDTO(Stat stat) {
        this(stat.getEmail(), stat.getNotificationAmount());
    }
}
