package com.aqmp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AqmpProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AqmpProducerApplication.class, args);
	}

}
