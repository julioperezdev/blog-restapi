package dev.protobot.blogrestapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ImageContent {

    @Id
    private Long id;

    private Long idTypeVisualContent;

    private String imageUrl;

    private String publicId;

    public ImageContent(Long id, Long idTypeVisualContent, String imageUrl, String publicId) {
        this.id = id;
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
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
