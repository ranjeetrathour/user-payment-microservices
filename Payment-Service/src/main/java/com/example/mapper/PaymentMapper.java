package com.example.mapper;

import com.example.dto.request.PaymentRequest;
import com.example.dto.request.response.PaymentResponse;
import com.example.entity.Payment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    Payment toPaymentRequest(PaymentRequest paymentRequest);

    List<PaymentResponse> toPayments(List<Payment> responses);
}
