package com.aqmp.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfiguration {

    @Value("${queue.name}")
    private String queueName;

    @Bean("${queue.name}")
    public Queue myQueue() {
        return new Queue(queueName, false);
    }

}
