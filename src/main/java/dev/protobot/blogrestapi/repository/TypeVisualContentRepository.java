package dev.protobot.blogrestapi.repository;

import dev.protobot.blogrestapi.model.TypeVisualContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TypeVisualContentRepository extends JpaRepository<TypeVisualContent, Long> {

    @Query(value = "SELECT * FROM TypeVisualContent", nativeQuery = true)
    List<TypeVisualContent> getAllTypeVisualContent();

    @Query(value = "SELECT * FROM TypeVisualContent WHERE id = :id ", nativeQuery = true)
    Optional<TypeVisualContent> getTypeVisualContentById(Long id);

    @Query(value = "EXEC saveTypeVisualContent @Name = :name ", nativeQuery = true)
    TypeVisualContent saveTypeVisualContent(String name);

    @Query(value = "EXEC deleteTypeVisualContentById @Id = :id ", nativeQuery = true)
    String deleteTypeVisualContentById(Long id);
}
