package dev.protobot.blogrestapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Newsletter {

    @Id
    private Long idUser;

    public Newsletter(Long idUser) {
        this.idUser = idUser;
    }

    public Newsletter() {
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
