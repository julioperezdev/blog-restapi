package dev.protobot.blogrestapi.repository;

import dev.protobot.blogrestapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> getAllCategory();

    Optional<Category> getCategoryById(Long id);

    Category saveCategory(String name);

    String deleteCategoryById(Long id);
}
