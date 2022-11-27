package com.aqmp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AmqpConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmqpConsumerApplication.class, args);
	}

}
