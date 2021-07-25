package dev.protobot.blogrestapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TypeVisualContent")
public class TypeVisualContent {

    @Id
    private Long id;

    private String name;

    public TypeVisualContent(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public TypeVisualContent(String name) {
        this.name = name;
    }

    public TypeVisualContent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
