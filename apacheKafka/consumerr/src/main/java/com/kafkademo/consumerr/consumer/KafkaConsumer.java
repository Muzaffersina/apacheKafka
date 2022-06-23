package com.kafkademo.consumerr.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

	@KafkaListener(topics = "${kafka.topicName}", groupId = "group_id")
	public void listener(String message) {
		System.out.println("message = " + message);

	}
}