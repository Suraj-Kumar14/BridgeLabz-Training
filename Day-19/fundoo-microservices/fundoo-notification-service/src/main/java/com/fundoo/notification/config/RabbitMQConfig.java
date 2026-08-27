package com.fundoo.notification.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	public static final String EXCHANGE = "notification.exchange";

	public static final String EMAIL_QUEUE = "email.queue";

	public static final String EMAIL_ROUTING_KEY = "email.notification";

	@Bean
	public TopicExchange notificationExchange() {

		return new TopicExchange(EXCHANGE);
	}

	@Bean
	public Queue emailQueue() {

		return QueueBuilder.durable(EMAIL_QUEUE).build();
	}

	@Bean
	public Binding emailBinding(Queue emailQueue, TopicExchange notificationExchange) {

		return BindingBuilder.bind(emailQueue).to(notificationExchange).with(EMAIL_ROUTING_KEY);
	}

	@Bean
	public JacksonJsonMessageConverter messageConverter() {

		return new JacksonJsonMessageConverter();
	}

	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, JacksonJsonMessageConverter converter) {

		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);

		rabbitTemplate.setMessageConverter(converter);

		return rabbitTemplate;
	}
}