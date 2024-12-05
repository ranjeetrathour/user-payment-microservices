package com.example.service.impl;


import com.example.dto.request.PaymentRequest;
import com.example.dto.request.response.PaymentResponse;
import com.example.entity.Payment;
import com.example.mapper.PaymentMapper;
import com.example.repository.PaymentRepository;
import com.example.service.PaymentService;
import com.example.util.LoggerUtil;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private static Logger log = LoggerUtil.getLogger(PaymentMapper.class);
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    @Override
    public void savePayment(PaymentRequest paymentRequest) {
        log.info("payment request from userId {} ", paymentRequest.getUserId());
        Payment payment = paymentMapper.toPaymentRequest(paymentRequest);
        payment.setPaymentStatus("SUCCESS");
        payment.setPaymentDate(LocalDateTime.now());
        try {
            paymentRepository.save(payment);
            log.info("payment saved successful ");
        } catch (Exception e) {
            payment.setPaymentStatus("FAILED");
            paymentRepository.save(payment);
            log.error("payment failed");
        }
    }

    @Override
    public List<PaymentResponse> findAllPaymentsByUserId(Long userId) {
        log.info("request send by user with user id {}", userId);
        try {
            List<Payment> responses = paymentRepository.findAllPaymentByUserId(userId);
//            List<PaymentResponse> paymentResponses = paymentMapper.toPayments(responses);
//            return paymentResponses;
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("jhsagjagjs");
        }

    }

}
