package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HeartBeatSend {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${spring.application.name}")
    private String serviceName;

    @Scheduled(fixedRate = 5000) // Every 10 seconds
    public void sendHeartbeat() {
        restTemplate.postForObject("http://localhost:8761/heartbeat/" + serviceName, null, String.class);
    }
}
