package com.example;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/heartbeat")
public class HeartBeatController {

    private final SSEController sseController;
    private final CustomRegistry registry;

    public HeartBeatController(SSEController sseController, CustomRegistry registry) {
        this.sseController = sseController;
        this.registry = registry;
    }


    @PostMapping("/{serviceName}")
    public String heartbeat(@PathVariable String serviceName) {
       boolean isRegistered = !CustomRegistry.getRegistry().containsKey(serviceName);
        if (isRegistered) {
            CustomRegistry.register(serviceName);

        } else {
            CustomRegistry.update(serviceName);
        }
        sseController.emmitRegistry();
        return "Heartbeat received for service: " + serviceName;
    }
}
