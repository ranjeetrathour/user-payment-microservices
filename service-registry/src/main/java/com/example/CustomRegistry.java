package com.example;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CustomRegistry {
    private static final Map<String, Long> registry = new ConcurrentHashMap<>();

    //adding new client to registry
    public static void register(String serviceName) {
        registry.put(serviceName, System.currentTimeMillis());
    }

    //removing client from registry
    public static void unregister(String serviceName) {
        registry.remove(serviceName);
    }

    //updating client in registry
    public static void update(String serviceName) {
        registry.put(serviceName, System.currentTimeMillis());
    }

    //geting all clients from registry
    public static Map<String, Long> getRegistry() {
        return registry;
    }
}
