package dev.protobot.blogrestapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AuthorCertificate {

    @Id
    private Long id;
    private String code;
    private Long idAuthor;

    public AuthorCertificate(Long id, String code, Long idAuthor) {
        this.id = id;
        this.code = code;
        this.idAuthor = idAuthor;
    }

    public AuthorCertificate(String code, Long idAuthor) {
        this.code = code;
        this.idAuthor = idAuthor;
    }

    public AuthorCertificate() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Long idAuthor) {
        this.idAuthor = idAuthor;
    }
}
