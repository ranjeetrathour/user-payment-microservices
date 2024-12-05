package com.user.dto.request.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.user.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UsersResponse extends BaseEntity {
    private Long userId;

    private String firstName;

    private String lastName;

    private String email;

    @JsonIgnore
    private String password;

    private String phone;

    private String address;
}
