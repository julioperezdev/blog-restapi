package dev.protobot.blogrestapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Author")
public class Author {

    @Id
    private Long id;

    private String email;

    @Column(name = "name")
    private String fullName;

    @Column(name = "imageUrl")
    private String imageUrl;

    @Column(name = "publicId")
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

    public Author(String email, String fullName) {
        this.email = email;
        this.fullName = fullName;
    }

    public Author(Long id, String email, String fullName) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
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

