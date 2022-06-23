package com.kafkademo.producerr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProducerrApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerrApplication.class, args);
	}

}
