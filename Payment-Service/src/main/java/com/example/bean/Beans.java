package com.example.bean;

import com.example.mapper.PaymentMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

    @Bean
    public PaymentMapper paymentMapper(){
        return Mappers.getMapper(PaymentMapper.class);
    }
}
