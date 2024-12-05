package com.user.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {

    private String userId;
    @Column(nullable = false)

    private String paymentMethod;

    @Column(nullable = false)
    private Double amount;

}
