package com.kafkademo.producerr.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kafkademo.producerr.topics.topicConfig.KafkaTopicConfig;

@Component
public class SchedulerForProducer {

	// Fixed Delay Scheduler

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Value(value = "${kafka.topicName}")
	public String topicName;

	@Scheduled(fixedDelay = 1000, initialDelay = 5000)
	public void scheduleTask() {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mmss.SSS");

		String startDate = simpleDateFormat.format(new Date());
		
		kafkaTemplate.send(topicName,startDate);
		
		System.out.println("Time information sent from Producer - " + startDate);
		
	}
}
