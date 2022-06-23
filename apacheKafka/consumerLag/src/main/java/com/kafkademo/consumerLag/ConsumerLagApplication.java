package com.kafkademo.consumerLag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ConsumerLagApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerLagApplication.class, args);
	}

}
