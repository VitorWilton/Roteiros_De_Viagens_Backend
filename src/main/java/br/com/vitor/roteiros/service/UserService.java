package br.com.vitor.roteiros.service;

import br.com.vitor.roteiros.dto.UserRegisterDTO;
import br.com.vitor.roteiros.model.User;
import br.com.vitor.roteiros.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(UserRegisterDTO userDto) {
        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new RuntimeException("Erro: E-mail já cadastrado!");
        }

        User newUser = new User();
        newUser.setUsername(userDto.getUsername());
        newUser.setEmail(userDto.getEmail());
        newUser.setPassword(passwordEncoder.encode(userDto.getPassword())); // Codificando a senha

        return userRepository.save(newUser);
    }
}