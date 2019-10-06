package com.sandy2friends.webservice.service;

import com.sandy2friends.webservice.dto.UserDTO;
import com.sandy2friends.webservice.mapper.UserMapper;
import com.sandy2friends.webservice.model.User;
import com.sandy2friends.webservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public Page<UserDTO> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable).map(new UserMapper());
    }

    @Transactional(readOnly = true)
    public UserDTO getUser(Long userId) {
        return new UserMapper()
                .apply(userRepository.findById(userId)
                        .orElseThrow(() -> new EntityNotFoundException("User with userId = " + userId + " Not Found")));
    }

    @Transactional
    public UserDTO saveUser(UserDTO userDto) {
        Optional<User> dbUser = userRepository.findById(userDto.getId());
        if (dbUser.isPresent()) {
            throw new EntityExistsException("User with userId = " + userDto.getId() + " Already Exist");
        } else {
            User user = User.builder()
                    .name(userDto.getName())
                    .author(userDto.getAuthor())
                    .date(LocalDate.now())
                    .build();
            return new UserMapper().apply(userRepository.save(user));
        }
    }


}
