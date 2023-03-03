package com.project.instaclone.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.instaclone.Entity.User;
import com.project.instaclone.common.Response;
import com.project.instaclone.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    UserService userService;

    @PostMapping()
    private Response<User> submitUser(@RequestBody @Valid User user) {
        Response<User> response = new Response<>();
        try {
            User savedUser = userService.saveUser(user);
            if (savedUser != null) {
                response.setData(savedUser);
                response.setResponseCode(HttpStatus.CREATED.value());
                response.setResponseMessage("User added successfully");
                response.setStatus(HttpStatus.CREATED);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setData(null);
            response.setResponseCode(HttpStatus.BAD_REQUEST.value());
            response.setResponseMessage("Error Occurred!");
            response.setStatus(HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @GetMapping("/{id}")
    private Response<User> getUserDetails(@PathVariable("id") @Valid Integer id) {
        Response<User> response = new Response<>();
        try {
            Optional<User> user = userService.getUserById(id);
            if (user.isPresent()) {
                response.setData(user.get());
                response.setResponseCode(HttpStatus.OK.value());
                response.setStatus(HttpStatus.OK);
                response.setResponseMessage("User found for User ID: " + id);
            } else {
                response.setData(null);
                response.setResponseCode(HttpStatus.NOT_FOUND.value());
                response.setStatus(HttpStatus.NOT_FOUND);
                response.setResponseMessage("User not found for User ID: " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setData(null);
            response.setResponseCode(HttpStatus.BAD_REQUEST.value());
            response.setResponseMessage("Error Occurred!");
            response.setStatus(HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @PutMapping("/{id}")
    public Response<User> updateUser(@RequestBody @Valid User updateUser, @PathVariable("id") @Valid Integer id) {
        Response<User> response = new Response<>();
        try {
            User user = userService.updateUser(id, updateUser);
            if (user != null) {
                response.setData(user);
                response.setResponseCode(HttpStatus.OK.value());
                response.setStatus(HttpStatus.OK);
                response.setResponseMessage("User Updated successfully for ID: " + id);
            } else {
                response.setData(null);
                response.setResponseCode(HttpStatus.NOT_FOUND.value());
                response.setStatus(HttpStatus.NOT_FOUND);
                response.setResponseMessage("User not found for User ID: " + id);
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.setData(null);
            response.setResponseCode(HttpStatus.BAD_REQUEST.value());
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setResponseMessage("Error Occurred!");

        }
        return response;
    }

    @DeleteMapping("/{id}")
    public Response<Boolean> deleteUser(@PathVariable("id") @Valid Integer id) {
        Response<Boolean> response = new Response<>();
        try {
            boolean user = userService.deleteUser(id);
            response.setData(user);
            response.setResponseCode(HttpStatus.NO_CONTENT.value());
            response.setResponseMessage("User has been deleted successfully!");
            response.setStatus(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            response.setData(null);
            response.setResponseCode(HttpStatus.BAD_REQUEST.value());
            response.setResponseMessage("Invalid request!");
            response.setStatus(HttpStatus.BAD_REQUEST);
        }
        return response;
    }
}
