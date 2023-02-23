package com.project.instaclone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.instaclone.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userrRepository;
}
