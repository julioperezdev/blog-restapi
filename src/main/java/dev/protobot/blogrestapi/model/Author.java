package dev.protobot.blogrestapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Author {

    @Id
    private Long id;

    private String email;

    private String fullName;

    private String imageUrl;

    private String publicId;

    public Author(Long id, String email, String fullName, String imageUrl, String publicId) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.imageUrl = imageUrl;
        this.publicId = publicId;
    }

    public Author(String email, String fullName, String imageUrl, String publicId) {
        this.email = email;
        this.fullName = fullName;
        this.imageUrl = imageUrl;
        this.publicId = publicId;
    }

    public Author() {
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPublicId() {
        return publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }
    
}

