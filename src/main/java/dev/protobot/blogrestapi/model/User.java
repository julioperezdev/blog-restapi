package dev.protobot.blogrestapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private Long id;

    private String email;

    //TODO: array with Likes of post


    public User(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public User(String email) {
        this.email = email;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}