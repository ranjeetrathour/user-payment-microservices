package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.Map;

@RestController
@RequestMapping("/sse")
public class SSEController {
    private final Sinks.Many<Map<String,Long>> sink = Sinks.many().replay().limit(1);

    @GetMapping("/registry")
    public Flux<Map<String,Long>> registry() { return sink.asFlux(); } // <1>

    public void emmitRegistry() {
       if (sink.tryEmitNext(CustomRegistry.getRegistry())==Sinks.EmitResult.OK) {
           System.out.println("Emitted");
       }else {
           System.out.println("Not Emitted");
       }
    }
}
