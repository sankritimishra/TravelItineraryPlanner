package org.example.Services;

import org.example.DTOs.UserDetailsDTO;
import org.example.Repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDetailsDTO userDetails(Long userId) {
        return userRepository.fullUserDetails(userId);
    }

    public void addDetails(UserDetailsDTO body) {
        userRepository.addNewUserDetails(body);
    }

    public void updateDetails(Long userId, UserDetailsDTO body) {
        userRepository.updateUserDetails(userId, body);
    }

    public void deleteDetails(Long userId) {
        userRepository.deleteUserDetails(userId);
    }
}
