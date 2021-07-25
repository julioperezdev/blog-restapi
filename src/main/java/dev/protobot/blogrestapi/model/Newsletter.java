package dev.protobot.blogrestapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Newsletter")
public class Newsletter {

    @Id
    private Long id;

    private String email;

    public Newsletter(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public Newsletter(String email) {
        this.email = email;
    }

    public Newsletter() {
    }

    public Long getId() {
        return id;
    }

    public void setIdUser(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
