package com.user.service.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.Map;

@Service
public class Consumer {

    @PostConstruct
    public void consumeEvents() {
        WebClient
                .builder()
                .baseUrl("http://localhost:8761/eureka")
                .build()
                .get()
                .uri("/sse/register")
                .retrieve()
                .bodyToFlux(Map.class)
                .doOnSubscribe(subscription -> System.out.println("Subscribed"))
                .retryWhen(Retry.backoff(3, Duration.ofDays(1000))
                        .doBeforeRetry(event -> System.out.println("Retrying...")))
                .subscribe(System.out::println);

    }
}
