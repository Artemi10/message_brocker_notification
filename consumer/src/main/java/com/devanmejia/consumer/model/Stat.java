package com.devanmejia.consumer.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@Document("statistics")
@NoArgsConstructor
@AllArgsConstructor
public class Stat {
    @Id
    private String id;
    private String email;
    private long notificationAmount;

    public static Stat empty(String email) {
        return Stat.builder()
                .email(email)
                .notificationAmount(1)
                .build();
    }

    public void incrementNotifications() {
        notificationAmount++;
    }
}
