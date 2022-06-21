package br.ufu.quiz.pooatividadefinalquiz.services;

import br.ufu.quiz.pooatividadefinalquiz.dto.UserDTO;
import br.ufu.quiz.pooatividadefinalquiz.entities.User;
import br.ufu.quiz.pooatividadefinalquiz.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDTO save(UserDTO userDTO) {
        Optional<User> user = userRepository.findByEmail(userDTO.getEmail());

        if (user.isPresent()) return null;

        User newUser = User.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .roles(userDTO.getRoles())
                .build();

        this.userRepository.save(newUser);

        return new UserDTO(newUser);
    }


    public UserDTO delete(UUID id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) return null;

        User deletedUser = user.get();
        userRepository.delete(deletedUser);

        return new UserDTO(deletedUser);
    }

    public UserDTO findById(UUID id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) return null;

        return new UserDTO(user.get());
    }

    public UserDTO findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isEmpty()) return null;

        return new UserDTO(user.get());
    }

    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(UserDTO::new).toList();
    }
}
