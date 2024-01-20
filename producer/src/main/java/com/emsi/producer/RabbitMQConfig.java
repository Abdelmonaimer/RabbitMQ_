package com.emsi.producer;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public DirectExchange firstExchange() {
        return new DirectExchange("firstExchange");
    }

    @Bean
    public DirectExchange secondExchange() {
        return new DirectExchange("secondExchange");
    }

    @Bean
    public Queue queueOne() {
        return new Queue("queueOne");
    }

    @Bean
    public Queue queueTwo() {
        return new Queue("queueTwo");
    }
}
