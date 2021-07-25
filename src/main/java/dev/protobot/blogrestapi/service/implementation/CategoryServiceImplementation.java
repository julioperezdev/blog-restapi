package dev.protobot.blogrestapi.service.implementation;

import dev.protobot.blogrestapi.model.Category;
import dev.protobot.blogrestapi.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImplementation implements CategoryService {


    @Override
    public List<Category> getAllCategory() {
        return null;
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        return Optional.empty();
    }

    @Override
    public Category saveCategory(Category category) {
        return null;
    }

    @Override
    public String deleteCategoryById(Long id) {
        return null;
    }
}
