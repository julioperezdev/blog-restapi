package dev.protobot.blogrestapi.repository;

import dev.protobot.blogrestapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT * FROM Category ", nativeQuery = true)
    List<Category> getAllCategory();

    @Query(value = "SELECT * FROM Category WHERE id = :id ", nativeQuery = true)
    Optional<Category> getCategoryById( @Param("id") Long id);

    @Query(value = "EXEC saveCategory @Name = :name ", nativeQuery = true)
    Category saveCategory(@Param("name") String name);

    @Query(value = "EXEC deleteCategoryById @Id = :id ", nativeQuery = true)
    String deleteCategoryById(@Param("id") Long id);
}
