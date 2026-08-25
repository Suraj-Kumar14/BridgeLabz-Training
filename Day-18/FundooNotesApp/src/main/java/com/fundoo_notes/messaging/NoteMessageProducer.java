package com.fundoo_notes.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.fundoo_notes.config.RabbitMQConfig;
import com.fundoo_notes.dto.RabbitMessageDTO;

@Service
public class NoteMessageProducer {

	private final RabbitTemplate rabbitTemplate;

	public NoteMessageProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public void sendNoteCreatedMessage(RabbitMessageDTO message) {

		rabbitTemplate.convertAndSend(RabbitMQConfig.NOTE_EXCHANGE, RabbitMQConfig.NOTE_CREATED_ROUTING_KEY, message);

		System.out.println("Message sent to RabbitMQ: " + message);
	}
}