package com.sandy2friends.webservice.web.rest;

import com.sandy2friends.webservice.dto.UserDTO;
import com.sandy2friends.webservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;

@RestController("users")
@RequiredArgsConstructor
public class UserEndPoint {

    private final UserService userService;

    @GetMapping()
    public ResponseEntity<Page<UserDTO>> getAllUsers(Pageable pageable) {
        return ResponseEntity.ok(userService.getAllUsers(pageable));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUser(
            @PathVariable(required = true) Long userId
    ) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @PostMapping
    public ResponseEntity<UserDTO> saveUser(
            @RequestBody(required = true) UserDTO user
    ) throws URISyntaxException {
        UserDTO userDto = userService.saveUser(user);
        return ResponseEntity
                .created(new URI(ServletUriComponentsBuilder.fromCurrentRequestUri().toString() + userDto.getId()))
                .body(userDto);
    }
}
