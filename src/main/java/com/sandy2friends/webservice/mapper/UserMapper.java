package com.sandy2friends.webservice.mapper;

import com.sandy2friends.webservice.dto.UserDTO;
import com.sandy2friends.webservice.model.User;

import java.util.function.Function;

public class UserMapper implements Function<User, UserDTO> {
    @Override
    public UserDTO apply(User user) {

        return UserDTO.builder()
                .Id(user.getId())
                .name(user.getName())
                .author(user.getAuthor())
                .date(user.getDate())
                .build();
    }
}