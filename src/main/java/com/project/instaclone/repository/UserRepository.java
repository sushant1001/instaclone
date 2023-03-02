package com.project.instaclone.repository;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.instaclone.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findById(@Valid String userId);

}
