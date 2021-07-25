package dev.protobot.blogrestapi.controller;

import dev.protobot.blogrestapi.dto.response.RestResponse;
import dev.protobot.blogrestapi.model.Category;
import dev.protobot.blogrestapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/getall")
    public RestResponse<List<Category>> getAllCategories() {
        List<Category> allCategory = categoryService.getAllCategory();
        return new RestResponse<>(HttpStatus.ACCEPTED, allCategory);
    }

    @GetMapping("/get/byid/{id}")
    public RestResponse<Optional<Category>> getCategoryById(@PathVariable Long id) {
        Optional<Category> optionalCategory = categoryService.getCategoryById(id);
        return new RestResponse<>(HttpStatus.ACCEPTED, optionalCategory);
    }

    @PostMapping("/save")
    public RestResponse<Category> saveCategory(@RequestBody Category category) {
        Category categoryCreated = categoryService.saveCategory(category);
        return new RestResponse<>(HttpStatus.CREATED, categoryCreated);
    }

    @DeleteMapping("/delete/byid/{id}")
    public RestResponse<String> deleteBlogById(@PathVariable Long id) {
        String responseService = categoryService.deleteCategoryById(id);
        return new RestResponse<>(HttpStatus.OK, responseService);
    }
}
