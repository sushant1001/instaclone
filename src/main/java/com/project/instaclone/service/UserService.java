package com.project.instaclone.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.project.instaclone.Entity.User;
import com.project.instaclone.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    UserRepository userRepository;

    public User saveUser(@Valid User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw e;
        }
    }

    public Optional<User> getUserById(@Valid Integer userId) {
        try {
            return userRepository.findById(userId);
        } catch (Exception e) {
            throw e;
        }
    }

    public Optional<User> updateUser(@Valid Integer id) {
        try {
            return userRepository.findById(id);
        } catch (Exception e) {
            throw e;
        }
    }

}
