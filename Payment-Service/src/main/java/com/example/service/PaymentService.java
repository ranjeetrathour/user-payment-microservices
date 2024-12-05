package com.example.service;


import com.example.dto.request.PaymentRequest;
import com.example.dto.request.response.PaymentResponse;

import java.util.List;

public interface PaymentService {
    void savePayment(PaymentRequest paymentRequest);

    List<PaymentResponse> findAllPaymentsByUserId(Long userId);
}
