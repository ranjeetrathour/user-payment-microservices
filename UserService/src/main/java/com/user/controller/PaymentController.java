package com.user.controller;

import com.user.dto.request.PaymentRequest;
import com.user.dto.request.response.TranscationResponse;
import com.user.service.impl.PaymentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
@AllArgsConstructor
public class PaymentController {

    private final PaymentServiceImpl paymentService;

    @PostMapping
    public ResponseEntity<?> sendPaymentRequest(@RequestBody PaymentRequest paymentRequest){
        try {
            paymentService.sendPaymentRequest(paymentRequest);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
    }
}
