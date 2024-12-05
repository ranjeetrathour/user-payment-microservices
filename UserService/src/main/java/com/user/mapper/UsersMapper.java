package com.user.mapper;


import com.user.dto.request.UsersRequest;
import com.user.dto.request.response.UsersResponse;
import com.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsersMapper {

    User toUserRequest(UsersRequest usersRequest);

    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "address", target = "address")
    UsersResponse toUser(User user);
}
