package com.kafkademo.producerr.producer.producerConfig;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.fasterxml.jackson.databind.ser.std.StringSerializer;

public class KafkaProducerConfig {
		
	@Value(value = "${kafka.bootstrapAddress}")
	public String bootstrapAddress;
	   @Bean
	    public ProducerFactory<String, String> producerFactory() {
	        Map<String, Object> configProps = new HashMap<>();
	        configProps.put(
	          ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, 
	          bootstrapAddress);
	        configProps.put(
	          ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, 
	          StringSerializer.class);
	        configProps.put(
	          ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, 
	          StringSerializer.class);
	        return new DefaultKafkaProducerFactory<>(configProps);
	    }

	    @Bean
	    public KafkaTemplate<String, String> kafkaTemplate() {
	        return new KafkaTemplate<>(producerFactory());
	    }
	}

