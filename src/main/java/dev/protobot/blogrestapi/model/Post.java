package dev.protobot.blogrestapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Entity
public class Post {

    @Id
    private Long id;

    private String title;

    private String description;

    private Long idCategory;

    private Long idTypeVisualContent;

    private Instant dates;

    private Long idAuthor;

    public Post(Long id, String title, String description, Long idCategory, Long idTypeVisualContent, Instant dates, Long idAuthor) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.idCategory = idCategory;
        this.idTypeVisualContent = idTypeVisualContent;
        this.dates = dates;
        this.idAuthor = idAuthor;
    }

    public Post(String title, String description, Long idCategory, Long idTypeVisualContent, Instant dates, Long idAuthor) {
        this.title = title;
        this.description = description;
        this.idCategory = idCategory;
        this.idTypeVisualContent = idTypeVisualContent;
        this.dates = dates;
        this.idAuthor = idAuthor;
    }

    public Post() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public Long getIdTypeVisualContent() {
        return idTypeVisualContent;
    }

    public void setIdTypeVisualContent(Long idTypeVisualContent) {
        this.idTypeVisualContent = idTypeVisualContent;
    }

    public Instant getDates() {
        return dates;
    }

    public void setDates(Instant dates) {
        this.dates = dates;
    }

    public Long getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Long idAuthor) {
        this.idAuthor = idAuthor;
    }
}
