package com.user.service;

import com.user.dto.request.PaymentRequest;
import com.user.dto.request.response.TranscationResponse;

import java.util.List;

public interface PaymentService {
    void sendPaymentRequest(PaymentRequest paymentRequest);

}
