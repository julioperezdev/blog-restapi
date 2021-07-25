package dev.protobot.blogrestapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ImagePresentation")
public class ImagePresentation {

    @Id
    @Column(name = "idPost")
    private Long idPost;

    @Column(name = "imageUrl")
    private String imageUrl;

    @Column(name = "publicId")
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
