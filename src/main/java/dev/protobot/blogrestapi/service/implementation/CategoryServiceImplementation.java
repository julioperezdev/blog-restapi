package dev.protobot.blogrestapi.service.implementation;

import dev.protobot.blogrestapi.helper.shared.CheckIfNullOrEmptyString;
import dev.protobot.blogrestapi.helper.shared.CheckIfNullOrZeroLong;
import dev.protobot.blogrestapi.helper.shared.CheckIfStringHaveNumber;
import dev.protobot.blogrestapi.helper.shared.ConvertStringToLowerCase;
import dev.protobot.blogrestapi.model.Category;
import dev.protobot.blogrestapi.repository.CategoryRepository;
import dev.protobot.blogrestapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImplementation implements CategoryService {


    private final CategoryRepository categoryRepository;

    private final CheckIfNullOrEmptyString checkIfNullOrEmptyString;

    private final CheckIfNullOrZeroLong checkIfNullOrZeroLong;

    private final CheckIfStringHaveNumber checkIfStringHaveNumber;

    private final ConvertStringToLowerCase convertStringToLowerCase;



    @Autowired
    public CategoryServiceImplementation(CategoryRepository categoryRepository, CheckIfNullOrEmptyString checkIfNullOrEmptyString, CheckIfNullOrZeroLong checkIfNullOrZeroLong, CheckIfStringHaveNumber checkIfStringHaveNumber, ConvertStringToLowerCase convertStringToLowerCase) {
        this.categoryRepository = categoryRepository;
        this.checkIfNullOrEmptyString = checkIfNullOrEmptyString;
        this.checkIfNullOrZeroLong = checkIfNullOrZeroLong;
        this.checkIfStringHaveNumber = checkIfStringHaveNumber;
        this.convertStringToLowerCase = convertStringToLowerCase;
    }

    @Override
    public List<Category> getAllCategory() {
        List<Category> allCategory = categoryRepository.getAllCategory();
        return allCategory;
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        Optional<Category> categoryById = categoryRepository.getCategoryById(id);
        return categoryById;
    }

    @Override
    public Category saveCategory(Category category) {
        String lowerCaseCategoryName = convertStringToLowerCase.convert(category.getName());
        Category categorySaved = categoryRepository.saveCategory(lowerCaseCategoryName);
        return categorySaved;
    }

    @Override
    public String deleteCategoryById(Long id) {
        return null;
    }
}
