package com.user.dto.request.response;

import java.time.LocalDateTime;

public class TranscationResponse {
    private String userId;

    private String paymentMethod; // e.g., CREDIT_CARD, DEBIT_CARD, UPI

    private Double amount;

    private LocalDateTime paymentDate; // When the payment was made

    private String paymentStatus; // e.g., SUCCESS, PENDING, FAILED
}
