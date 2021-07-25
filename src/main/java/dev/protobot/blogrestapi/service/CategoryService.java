package dev.protobot.blogrestapi.service;

import dev.protobot.blogrestapi.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> getAllCategory();

    Optional<Category> getCategoryById(Long id);

    Category saveCategory(Category category);

    void deleteCategoryById(Long id);

}
