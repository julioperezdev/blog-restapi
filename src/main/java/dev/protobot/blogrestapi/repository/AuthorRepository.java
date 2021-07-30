package dev.protobot.blogrestapi.repository;

import dev.protobot.blogrestapi.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {


    @Query(value = "SELECT * FROM Author; ", nativeQuery = true)
    List<Author> getAllAuthors();

    @Query(value = "SELECT * FROM Author WHERE id = :id ", nativeQuery = true)
    Optional<Author> getAuthorById(@Param("id") Long id);

    @Query(value = "EXEC saveAuthorWithMainInformation @Name = :name , @Email = :email ", nativeQuery = true)
    Author saveAuthorWithMainInformation(
            @Param("name") String name,
            @Param("email") String email);

    @Query(value = "EXEC deleteAuthorById @Id = :id ", nativeQuery = true)
    String deleteAuthorById(@Param("id") Long id);
}
