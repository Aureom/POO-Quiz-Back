package br.ufu.quiz.pooatividadefinalquiz.services;

import br.ufu.quiz.pooatividadefinalquiz.dto.UserDTO;
import br.ufu.quiz.pooatividadefinalquiz.entities.User;
import br.ufu.quiz.pooatividadefinalquiz.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO save(UserDTO userDTO) {
        Optional<User> user = userRepository.findByEmail(userDTO.getEmail());

        if (user.isPresent()) {
            throw new IllegalArgumentException("User already exists");
        }

        User newUser = User.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .role(userDTO.getRole())
                .build();

        this.userRepository.save(newUser);

        return new UserDTO(newUser);

    }

    public UserDTO delete(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }

        User deletedUser = user.get();
        userRepository.delete(deletedUser);

        return new UserDTO(deletedUser);
    }

    public UserDTO findById(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }

        return new UserDTO(user.get());
    }

    public UserDTO findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }

        return new UserDTO(user.get());
    }
}
