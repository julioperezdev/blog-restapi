package dev.protobot.blogrestapi.service.implementation;

import dev.protobot.blogrestapi.helper.shared.CheckIfNullOrEmptyString;
import dev.protobot.blogrestapi.helper.shared.CheckIfNullOrZeroLong;
import dev.protobot.blogrestapi.helper.shared.CheckIfStringHaveNumber;
import dev.protobot.blogrestapi.helper.shared.ConvertStringToLowerCase;

import dev.protobot.blogrestapi.model.Category;
import dev.protobot.blogrestapi.repository.CategoryRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplementationTest {

    @Mock
    CheckIfNullOrEmptyString checkIfNullOrEmptyString;

    @Mock
    CheckIfNullOrZeroLong checkIfNullOrZeroLong;

    @Mock
    CheckIfStringHaveNumber checkIfStringHaveNumber;

    @Mock
    ConvertStringToLowerCase convertStringToLowerCase;

    @Mock
    CategoryRepository categoryRepository;

    @InjectMocks
    CategoryServiceImplementation service;

    @Nested
    public class getAllCategoriesCases{

        @Test
        void itShouldGetAllCategoriesWithZeroSizeHappyCase() {
            //given
            List<Category> allCategories = new ArrayList<>();
            given(categoryRepository.getAllCategory()).willReturn(allCategories);

            //when
            service.getAllCategory();

            //then
            then(categoryRepository).should().getAllCategory();
            assertNotNull(allCategories);
            assertEquals( 0, allCategories.size());
        }

        @Test
        void itShouldGetAllCategoriesWithOneSizeHappyCase() {
            //given
            Category category = new Category();
            List<Category> allCategories = new ArrayList<>();
            allCategories.add(category);
            given(categoryRepository.getAllCategory()).willReturn(allCategories);

            //when
            service.getAllCategory();

            //then
            then(categoryRepository).should().getAllCategory();
            assertNotNull(allCategories);
            assertEquals( 1, allCategories.size());
        }

    }

    @Nested
    public class getCategoryByIdCases{

        @Test
        void itShouldGetCategoryByIdHappyCase() {
            //given
            Category categoryOne = new Category(1L, "it");
            Category categoryTwo = new Category(2L, "wallets");
            List<Category> list = new ArrayList<>();
            list.add(categoryOne);
            list.add(categoryTwo);
            given(categoryRepository.getCategoryById(anyLong())).willReturn(Optional.of(categoryOne));

            //when
            Optional<Category> result = service.getCategoryById(1L);

            //then
            then(categoryRepository).should().getCategoryById(anyLong());
            then(categoryRepository).shouldHaveNoMoreInteractions();
            assertTrue(result.isPresent());
            assertEquals(categoryOne, result.get());
        }

    }

    @Nested
    public class saveCategoryCases{
        @Test
        @Disabled
        void itShouldSaveCategoryHappyCase() {
            //given
            Category categoryBefore = new Category("ai");
            Category categoryAfter = new Category("ai");
            given(convertStringToLowerCase.convert(anyString()))
                    .willReturn(categoryAfter.getName());
            given(categoryRepository.saveCategory(anyString()))
                    .willReturn(new Category(1L, categoryAfter.getName()));

            //when
            Category categoryCreated = categoryRepository.saveCategory(categoryBefore.getName());

            //then
            then(convertStringToLowerCase).should().convert(categoryBefore.getName());
            then(categoryRepository).should().saveCategory(categoryAfter.getName());
            //assertNotNull(categoryCreated);
        }

    }

    @Nested
    public class deleteCategoryByIdCases{

    }




}