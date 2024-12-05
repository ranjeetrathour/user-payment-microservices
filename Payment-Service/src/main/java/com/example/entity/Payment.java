package com.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "payment_service")
public class Payment extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    private Long userId;

    @Column(nullable = false)
    private String paymentMethod; // e.g., CREDIT_CARD, DEBIT_CARD, UPI

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private LocalDateTime paymentDate; // When the payment was made

    @Column(nullable = false)
    private String paymentStatus; // e.g., SUCCESS, PENDING, FAILED

}
