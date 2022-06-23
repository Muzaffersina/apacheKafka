package com.kafkademo.consumerLag.lagService;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.val;

@Service
public class LiveLagAnalyzerService {
	
	@Autowired
	private LagAnalyzerService lagAnalyzerService;

	@Value(value = "${kafka.groupId}")
	private String groupId; 
	
	@Scheduled(fixedDelay = 5000L)
	public void liveLagAnalysis() throws ExecutionException,InterruptedException {
		lagAnalyzerService.analyzeLag(groupId);
	}
}
