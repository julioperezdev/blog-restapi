package dev.protobot.blogrestapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PostLikesUser {

    @Id
    private Long id;

    private Long idPost;

    private Long idUser;

    public PostLikesUser(Long id, Long idPost, Long idUser) {
        this.id = id;
        this.idPost = idPost;
        this.idUser = idUser;
    }

    public PostLikesUser(Long idPost, Long idUser) {
        this.idPost = idPost;
        this.idUser = idUser;
    }

    public PostLikesUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
