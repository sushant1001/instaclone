package com.project.instaclone.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "Users")
public class Users {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String userId;
    private String userName;
    private String name;
    private String profilePicture;

    public Users() {
    }

    public Users(int id, String userId, String userName, String name, String profilePicture) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.name = name;
        this.profilePicture = profilePicture;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfilePicture() {
        return this.profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

}
