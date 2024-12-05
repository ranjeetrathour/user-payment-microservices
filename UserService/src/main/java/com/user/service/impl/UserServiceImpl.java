package com.user.service.impl;

import com.user.dto.request.UsersRequest;
import com.user.dto.request.response.PaymentResponse;
import com.user.dto.request.response.UsersResponse;
import com.user.entity.User;
import com.user.exception.GenericException;
import com.user.exception.customException.UserNotFoundException;
import com.user.mapper.UsersMapper;
import com.user.repository.UsersRepo;
import com.user.service.UserService;
import com.user.util.LoggerUtil;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.user.util.Constant.PAYMENT_SERVICE_URL;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerUtil.getLogger(UserServiceImpl.class);
    private final UsersRepo usersRepo;
    private final UsersMapper usersMapper;
    private final RestTemplate restTemplate;

    // Create User
    public void userCreated(UsersRequest usersRequest) {
        User user = usersMapper.toUserRequest(usersRequest);
        try {
            usersRepo.save(user);
            log.info("User created with user ID {} ", user.getUserId());
        } catch (Exception exception) {
            log.warn("User creation failed: {}", exception.getMessage());
        }
    }

    // Find User by ID
    public UsersResponse findUserByUserId(Long userId) {
        Optional<User> user = usersRepo.findUserByUserId(userId);
        if (user.isEmpty()) {
            log.warn("User not found with ID: {}", userId);
            throw new UserNotFoundException("User not found with ID: " + userId);
        }
        log.info("User found with ID: {}", userId);
        User user1 = user.get();
        return usersMapper.toUser(user1);
    }

    //find all payments by user
    public List<PaymentResponse> allPaymentsByUserId(Long userId) {
        try {
            String uri = PAYMENT_SERVICE_URL + "all-payments/" + userId;
            PaymentResponse[] responses = restTemplate.getForObject(uri, PaymentResponse[].class);
            // Convert the array to a list and return
            return responses != null ? Arrays.asList(responses) : Collections.emptyList();
        } catch (RestClientException e) {
            log.error("Error fetching transaction records for user ID: {}", userId, e);
            throw new GenericException(HttpStatus.SERVICE_UNAVAILABLE.value(), "service is down or not reacheable");
        }
    }

}
