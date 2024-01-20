package com.emsi.producer;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class ProducerController {
    private final RabbitTemplate rabbitTemplate;
    private final DirectExchange firstExchange;
    private final DirectExchange secondExchange;

    public ProducerController(RabbitTemplate rabbitTemplate, DirectExchange firstExchange, DirectExchange secondExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.firstExchange = firstExchange;
        this.secondExchange = secondExchange;
    }

    @PostMapping("/send")
    public String sendMessage() {
        rabbitTemplate.convertAndSend(firstExchange.getName(), "routingKey", "Message for first exchange");
        rabbitTemplate.convertAndSend(secondExchange.getName(), "routingKey", "Message for second exchange");
        return "Messages sent successfully";
    }
}
