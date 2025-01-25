package com.example;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Map;

@Component
public class HealthMonitor {

    private final SSEController sseController;

    public HealthMonitor(SSEController sseController) {
        this.sseController = sseController;
    }

    @Scheduled(fixedRate = 5000)
    private void checkHealth() {
       long currentTime = System.currentTimeMillis();
        Iterator<Map.Entry<String,Long>> iterator = CustomRegistry.getRegistry().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String,Long> entry = iterator.next();
            if (currentTime - entry.getValue() > 5000) {
                CustomRegistry.unregister(entry.getKey());
                iterator.remove();
                sseController.emmitRegistry();
            }
        }
    }
}
