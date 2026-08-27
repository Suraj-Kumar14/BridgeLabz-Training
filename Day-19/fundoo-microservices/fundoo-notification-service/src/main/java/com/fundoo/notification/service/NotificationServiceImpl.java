package com.fundoo.notification.service;

import org.springframework.stereotype.Service;

import com.fundoo.notification.messaging.NotificationMessage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationServiceImpl implements NotificationService {

	private final EmailService emailService;

	@Override
	public void sendNotification(NotificationMessage notification) {

		emailService.sendEmail(notification.getEmail(), notification.getSubject(), notification.getBody());

		log.info("Notification processed successfully. type={}, recipient={}", notification.getType(),
				notification.getEmail());
	}
}