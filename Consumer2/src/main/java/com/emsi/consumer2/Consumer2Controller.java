package com.emsi.consumer2;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer2Controller {
    @RabbitListener(queues = "queueTwo")
    public void consumeMessage(String message) {
        System.out.println("Second Consumer Received: " + message);
    }
}
