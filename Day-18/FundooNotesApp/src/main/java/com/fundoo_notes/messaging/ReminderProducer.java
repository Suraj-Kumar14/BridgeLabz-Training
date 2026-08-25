package com.fundoo_notes.messaging;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.fundoo_notes.dto.request.reminder.ReminderMessageDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class ReminderProducer {

	private static final String REMINDER_QUEUE = "reminder-queue";

	private final JmsTemplate jmsTemplate;

	public void sendMessage(ReminderMessageDTO message) {

		jmsTemplate.convertAndSend(REMINDER_QUEUE, message);

		log.info("Reminder sent to JMS queue. reminderId={}, userId={}", message.getReminderId(), message.getUserId());
	}
}