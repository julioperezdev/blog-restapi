package dev.protobot.blogrestapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VideoContent")
public class VideoContent {

    @Id
    @Column(name = "idPost")
    private Long idPost;

    @Column(name = "idTypeVisualContent")
    private Long idTypeVisualContent;

    @Column(name = "videoUrl")
    private String videoUrl;

    public VideoContent(Long idPost, Long idTypeVisualContent, String videoUrl) {
        this.idPost = idPost;
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

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
