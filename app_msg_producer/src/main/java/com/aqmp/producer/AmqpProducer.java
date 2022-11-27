package com.aqmp.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AmqpProducer {

    private final RabbitTemplate rabbitTemplate;
    private final Logger logger = LoggerFactory.getLogger(AmqpProducer.class);
    private final String msg1 = "Type 1!";
    private final String msg2 = "Type 2!";
    private final Queue queue;

    public AmqpProducer(RabbitTemplate rabbitTemplate, Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }

    @Scheduled(fixedDelay = 5000, initialDelay = 500)
    public void sendMessagesToQueue() {
        sendMessageToQueue(msg1);
        sendMessageToQueue(msg2);
    }

    private void sendMessageToQueue(String msg) {
        logger.info(String.format("Sending message to queue(%s): %s", queue.getName(), msg));
        rabbitTemplate.convertAndSend(queue.getName(), msg);
    }

}
