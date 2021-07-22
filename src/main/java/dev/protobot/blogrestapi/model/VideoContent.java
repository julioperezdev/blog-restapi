package dev.protobot.blogrestapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VideoContent {

    @Id
    private Long id;

    private Long idTypeVisualContent;

    private String videoUrl;

    public VideoContent(Long id, Long idTypeVisualContent, String videoUrl) {
        this.id = id;
        this.idTypeVisualContent = idTypeVisualContent;
        this.videoUrl = videoUrl;
    }

    public VideoContent(Long idTypeVisualContent, String videoUrl) {
        this.idTypeVisualContent = idTypeVisualContent;
        this.videoUrl = videoUrl;
    }

    public VideoContent() {
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

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
