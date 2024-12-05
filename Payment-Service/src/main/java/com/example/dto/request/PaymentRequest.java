package com.example.dto.request;

import com.example.entity.BaseEntity;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest extends BaseEntity {

    private String userId;

    @Column(nullable = false)
    private String paymentMethod;

    @Column(nullable = false)
    private Double amount;
}
