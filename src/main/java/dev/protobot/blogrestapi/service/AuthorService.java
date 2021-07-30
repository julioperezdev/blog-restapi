package dev.protobot.blogrestapi.service;

import dev.protobot.blogrestapi.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> getAllAuthors();

    Optional<Author> getAuthorById(Long id);

    Author saveAuthorWithMainInformation(Author author);

    String deleteAuthorById(Long id);
}
