package com.user.service.impl;

import com.user.dto.request.PaymentRequest;
import com.user.service.PaymentService;
import com.user.util.LoggerUtil;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import static com.user.util.Constant.PAYMENT_SERVICE_URL;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private static final Logger log = LoggerUtil.getLogger(PaymentServiceImpl.class);
    private final RestTemplate restTemplate;

    @Override
    public void sendPaymentRequest(PaymentRequest paymentRequest) {
        log.info("Payment request from user ID: {}", paymentRequest.getUserId());

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<PaymentRequest> requestEntity = new HttpEntity<>(paymentRequest, headers);
            ResponseEntity<String> response = restTemplate.postForEntity(PAYMENT_SERVICE_URL+"save", requestEntity, String.class);
            log.info("Response from Payment Service: {}", response.getBody());
        } catch (Exception e) {
            log.error("Error sending payment request: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to send payment request", e);
        }
    }

}
