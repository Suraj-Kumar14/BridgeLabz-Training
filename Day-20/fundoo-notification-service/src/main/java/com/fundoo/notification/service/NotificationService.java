package com.fundoo.notification.service;

import com.fundoo.notification.messaging.NotificationMessage;

public interface NotificationService {

	void sendNotification(NotificationMessage notification);
}