package br.com.vitor.roteiros.controller;

import br.com.vitor.roteiros.dto.UserRegisterDTO;
import br.com.vitor.roteiros.dto.UserResponseDTO;
import br.com.vitor.roteiros.model.User;
import br.com.vitor.roteiros.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRegisterDTO userDto) {
        try {
            User newUser = userService.createUser(userDto);

            UserResponseDTO responseDto = new UserResponseDTO();
            responseDto.setId(newUser.getId());
            responseDto.setUsername(newUser.getUsername());
            responseDto.setEmail(newUser.getEmail());

            return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}