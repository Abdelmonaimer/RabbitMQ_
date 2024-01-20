package com.emsi.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerController {
    @RabbitListener(queues = "queueOne")
    public void consumeMessage(String message) {
        System.out.println("First Consumer Received: " + message);
    }
}
