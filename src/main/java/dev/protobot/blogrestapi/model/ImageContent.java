package dev.protobot.blogrestapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ImageContent")
public class ImageContent {

    @Id
    private Long idPost;

    @Column(name = "idTypeVisualContent")
    private Long idTypeVisualContent;

    @Column(name = "imageUrl")
    private String imageUrl;

    @Column(name = "publicId")
    private String publicId;

    public ImageContent(Long idPost, Long idTypeVisualContent, String imageUrl, String publicId) {
        this.idPost = idPost;
        this.idTypeVisualContent = idTypeVisualContent;
        this.imageUrl = imageUrl;
        this.publicId = publicId;
    }

    public ImageContent(Long idTypeVisualContent, String imageUrl, String publicId) {
        this.idTypeVisualContent = idTypeVisualContent;
        this.imageUrl = imageUrl;
        this.publicId = publicId;
    }

    public ImageContent() {
    }

    public Long getId() {
        return idPost;
    }

    public void setId(Long idPost) {
        this.idPost = idPost;
    }

    public Long getIdTypeVisualContent() {
        return idTypeVisualContent;
    }

    public void setIdTypeVisualContent(Long idTypeVisualContent) {
        this.idTypeVisualContent = idTypeVisualContent;
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
