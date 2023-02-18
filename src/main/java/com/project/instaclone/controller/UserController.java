package com.project.instaclone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.instaclone.Entity.Users;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping(value="")
    private boolean submitUser(@RequestBody Users users ){

        return true;
        
    }

    @GetMapping("/{userid}")
    private Users getUserDetails(@PathVariable("userid") String userId ){

        return new Users();
    }
    


    
}
