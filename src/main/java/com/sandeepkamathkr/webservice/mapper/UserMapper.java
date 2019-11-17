package com.sandeepkamathkr.webservice.mapper;

import com.sandeepkamathkr.webservice.dto.UserDTO;
import com.sandeepkamathkr.webservice.model.User;

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