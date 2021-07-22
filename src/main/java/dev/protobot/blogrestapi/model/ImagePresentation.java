package dev.protobot.blogrestapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ImagePresentation {

    @Id
    private Long idPost;

    private String imageUrl;

    private String publicId;

    public ImagePresentation(Long idPost, String imageUrl, String publicId) {
        this.idPost = idPost;
        this.imageUrl = imageUrl;
        this.publicId = publicId;
    }

    public ImagePresentation(String imageUrl, String publicId) {
        this.imageUrl = imageUrl;
        this.publicId = publicId;
    }

    public ImagePresentation() {
    }

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
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
