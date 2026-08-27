package com.fundoo.notification.messaging;

import com.fundoo.notification.enums.NotificationType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationMessage {

    private String email;

    private String subject;

    private String body;

    private NotificationType type;
}