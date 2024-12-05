package com.user.controller;

import com.user.dto.request.UsersRequest;
import com.user.dto.request.response.PaymentResponse;
import com.user.dto.request.response.UsersResponse;
import com.user.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    // Save User
    @PostMapping("/save")
    public ResponseEntity<String> savedUser(@RequestBody UsersRequest usersRequest) {
        userService.userCreated(usersRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully!");
    }

    //find user
    @GetMapping("/{userId}")
    public ResponseEntity<UsersResponse> findUser(@PathVariable Long userId) {
        final var userResponse = userService.findUserByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }

    //get all transaction
    @GetMapping("/transcations/{userId}")
    public ResponseEntity<List<PaymentResponse>> paymentResponse(@PathVariable Long userId){
        final var paymentResponse = userService.allPaymentsByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(paymentResponse);
    }



}
