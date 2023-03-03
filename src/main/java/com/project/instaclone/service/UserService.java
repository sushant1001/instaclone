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

    public User updateUser(@Valid Integer id, @Valid User updateUser) throws Exception {
        try {
            Optional<User> user = userRepository.findById(id);
            if (user.isPresent()) {
                User updatedUser = user.get();
                updatedUser.setName(updateUser.getName());
                updatedUser.setProfilePicture(updateUser.getProfilePicture());
                updatedUser.setUserName(updateUser.getUserName());
                return userRepository.save(updatedUser);

            } else {
                throw new Exception("User does not exist");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean deleteUser(@Valid Integer id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

}
