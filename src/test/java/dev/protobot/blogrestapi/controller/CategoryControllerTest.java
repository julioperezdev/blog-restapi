package dev.protobot.blogrestapi.controller;

import dev.protobot.blogrestapi.model.Category;
import dev.protobot.blogrestapi.service.implementation.CategoryServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@ExtendWith(MockitoExtension.class)
class CategoryControllerTest {

    @Mock
    CategoryServiceImplementation categoryServiceImplementation;

    @InjectMocks
    CategoryController controller;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Nested
    public class itShouldGetAllCategoriesCases{

        List<Category> categories = new ArrayList<>();
        Category categoryA = new Category(1L, "Java");
        Category categoryB = new Category(2L, "Sql");
        Category categoryC = new Category(3L, "Docker");

        @BeforeEach
        void setUp() {
            categories.add(categoryA);
            categories.add(categoryB);
            categories.add(categoryC);
        }

        @Test
        void itShouldGetAllCategoriesHappyCase() throws Exception {
            //given
            given(categoryServiceImplementation.getAllCategory()).willReturn(categories);
            //when
            controller.getAllCategories();
            //then
            then(categoryServiceImplementation).should().getAllCategory();
            assertEquals(3, categories.size());
            mockMvc.perform(get("/api/v1/category/getall"))
                    //.andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    //.andExpect(jsonPath("$.status", is("OK")))
                    .andExpect(jsonPath("$.body", hasSize(3)));
        }
    }

    @Nested
    public class itShouldGetCategoryByIdCases{

        Long idA = 1L;
        Long idB = 2L;
        Long idC = 3L;
        Category categoryA = new Category(1L, "Java");
        Category categoryB = new Category(2L, "Sql");
        Category categoryC = new Category(3L, "Docker");

        @BeforeEach
        void setUp() {
        }

        @Test
        void itShouldGetCategoryByIdHappyCase() throws Exception {
            //given
            given(categoryServiceImplementation.getCategoryById(anyLong())).willReturn(Optional.of(categoryA));
            //when
            controller.getCategoryById(idA);
            //then
            then(categoryServiceImplementation).should().getCategoryById(anyLong());
            //assertEquals(3, categories.size());
            mockMvc.perform(get("/api/v1/category/get/byid/1"))
                    //.andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON));
                    //.andExpect(jsonPath("$.status", is("OK")));
        }
    }

    @Nested
    public class itShouldSaveCategoryCase{

        Category toCreateBlog = new Category("java");
        Category createdBlog = new Category(1L,"java");

        @Test
        void itShouldSaveCategoryHappyCase() throws Exception {
            //given
            given(categoryServiceImplementation.saveCategory(toCreateBlog))
                    .willReturn(createdBlog);

            //when
            controller.saveCategory(toCreateBlog);

            //then
            then(categoryServiceImplementation).should().saveCategory(any(Category.class));
//            mockMvc.perform(post("/api/v1/blog/save"))
//                    .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        }
    }

    @Nested
    public class itShouldDeleteCategoryByIdCase{

        @Test
        void itShouldDeleteByIdHappyCase() throws Exception {
            //given
            Long id = 1L;
            String responseService = "OK";
            given(categoryServiceImplementation.deleteCategoryById(anyLong())).willReturn(responseService);

            //when
            controller.deleteBlogById(id);

            //then
            then(categoryServiceImplementation).should().deleteCategoryById(id);
            mockMvc.perform(delete("/api/v1/category/delete/byid/"+id))
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        }
    }

}