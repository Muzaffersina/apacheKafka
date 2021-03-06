package com.kafkademo.producerr.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Value(value = "${kafka.topicName}")
	public String topicName;
	
	public void sendMessage(String msg) {
		kafkaTemplate.send(topicName,msg);
	}

}
