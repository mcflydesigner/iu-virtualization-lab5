package com.aqmp.listener;

import com.aqmp.model.MsgFirst;
import com.aqmp.model.MsgSecond;
import com.aqmp.repository.MsgFirstRepository;
import com.aqmp.repository.MsgSecondRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

@RabbitListener(queues = "${queue.name}")
public class AmqpListener {

    private final Logger logger = LoggerFactory.getLogger(AmqpListener.class);
    private final String id = UUID.randomUUID().toString();
    private final Queue queue;
    private final MsgFirstRepository msgFirstRepository;
    private final MsgSecondRepository msgSecondRepository;

    public AmqpListener(Queue queue,
                        MsgFirstRepository msgFirstRepository,
                        MsgSecondRepository msgSecondRepository) {
        this.queue = queue;
        this.msgFirstRepository = msgFirstRepository;
        this.msgSecondRepository = msgSecondRepository;
    }

    @RabbitHandler
    public void processString(String in) {
        processMsg(in);
    }

    @RabbitHandler
    public void processBytes(byte[] message) {
        String in = new String(message, StandardCharsets.UTF_8);
        processMsg(in);
    }

    private void processMsg(String in) {
        logger.info(
                String.format("Processing message by {consumer %s} from the queue(%s): %s", id, queue.getName(), in)
        );
        if (in.toLowerCase().startsWith("type 1")) {
            logger.info("Got type 1 message, saving it to the database");
            msgFirstRepository.save(new MsgFirst(in));
        } else if (in.toLowerCase().startsWith("type 2")) {
            logger.info("Got type 2 message, saving it to the database");
            msgSecondRepository.save(new MsgSecond(in));
        }
    }

}
