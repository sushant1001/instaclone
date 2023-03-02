package com.project.instaclone.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "USER_NAME")
    @NotNull(message = "User Name cannot be blank")
    @NotBlank(message = "User Name cannot be blank")
    private String userName;

    @Column(name = "NAME")
    @NotNull(message = "Name cannot be blank")
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Column(name = "PROFILE_PICTURE")
    private String profilePicture;

}
