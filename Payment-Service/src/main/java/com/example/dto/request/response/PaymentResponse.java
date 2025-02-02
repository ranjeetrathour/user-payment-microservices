package com.example.dto.request.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse {

    private String userId;

    private String paymentMethod; // e.g., CREDIT_CARD, DEBIT_CARD, UPI

    private Double amount;

    private LocalDateTime paymentDate; // When the payment was made

    private String paymentStatus; // e.g., SUCCESS, PENDING, FAILED

}
