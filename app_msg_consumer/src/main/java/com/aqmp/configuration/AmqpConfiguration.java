package com.aqmp.configuration;

import com.aqmp.listener.AmqpListener;
import com.aqmp.repository.MsgFirstRepository;
import com.aqmp.repository.MsgSecondRepository;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Bean
    public AmqpListener amqpListener(@Qualifier("${queue.name}") Queue queue,
                                      MsgFirstRepository msgFirstRepository,
                                      MsgSecondRepository msgSecondRepository) {
        return new AmqpListener(queue, msgFirstRepository, msgSecondRepository);
    }

}
