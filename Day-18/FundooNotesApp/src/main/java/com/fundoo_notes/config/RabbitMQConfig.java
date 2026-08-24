package com.fundoo_notes.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMQConfig {

 
    // Exchange 
    public static final String NOTE_EXCHANGE =
            "fundoo.note.exchange";


    // Queue
    public static final String NOTE_QUEUE =
            "fundoo.note.queue";


    // Routing Key
    public static final String NOTE_CREATED_ROUTING_KEY =
            "note.created";


    // Exchange Bean
    @Bean
    public DirectExchange noteExchange() {

        return new DirectExchange(
                NOTE_EXCHANGE,
                true,
                false
        );
    }


    // Queue Bean

    @Bean
    public Queue noteQueue() {

        return new Queue(
                NOTE_QUEUE,
                true
        );
    }


    // Binding
 
    @Bean
    public Binding noteBinding(
            Queue noteQueue,
            DirectExchange noteExchange) {

        return BindingBuilder
                .bind(noteQueue)
                .to(noteExchange)
                .with(NOTE_CREATED_ROUTING_KEY);
    }


    // JSON Message Converter
 
    @Bean
    public JacksonJsonMessageConverter jacksonJsonMessageConverter() {

        return new JacksonJsonMessageConverter();
    }


    // RabbitTemplate
 
    @Bean
    public RabbitTemplate rabbitTemplate(
            ConnectionFactory connectionFactory,
            JacksonJsonMessageConverter messageConverter) {

        RabbitTemplate rabbitTemplate =
                new RabbitTemplate(connectionFactory);

        rabbitTemplate.setMessageConverter(
                messageConverter
        );

        return rabbitTemplate;
    }


    // RabbitMQ Listener Factory

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(
            ConnectionFactory connectionFactory,
            JacksonJsonMessageConverter messageConverter) {

        SimpleRabbitListenerContainerFactory factory =
                new SimpleRabbitListenerContainerFactory();

        factory.setConnectionFactory(
                connectionFactory
        );

        factory.setMessageConverter(
                messageConverter
        );

        return factory;
    }
}