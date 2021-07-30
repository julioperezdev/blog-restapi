package dev.protobot.blogrestapi.controller;

import dev.protobot.blogrestapi.model.Author;
import dev.protobot.blogrestapi.service.implementation.AuthorServiceImplementation;
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

import static org.hamcrest.Matchers.hasLength;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(MockitoExtension.class)
class AuthorControllerTest {

    @Mock
    AuthorServiceImplementation authorServiceImplementation;

    @InjectMocks
    AuthorController controller;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Nested
    public class getAllAuthorsCases{
        List<Author> allAuthor = new ArrayList<>();
        Author authorA = new Author(
                "emailA", 
                "nameA", 
                "urlA", 
                "publicA");

        @BeforeEach
        void setUp() {
            allAuthor.add(authorA);
        }

        @Test
        void itShouldGetAllAuthorHappyCase() throws Exception {
            //given
            given(authorServiceImplementation.getAllAuthors()).willReturn(allAuthor);
            //when
            controller.getAllAuthors();
            //then
            then(authorServiceImplementation).should().getAllAuthors();
            assertEquals(1, allAuthor.size());
            mockMvc.perform(get("/api/v1/author/getall"))
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.body", hasSize(1)));
        }
    }

    @Nested
    public class getAuthorByIdCases{

        Author authorA = new Author(
                2L,
                "emailA",
                "nameA",
                "urlA",
                "publicA");

        @Test
        void itShouldGetAuthorByIdHappyCase() throws Exception {
            //given
            given(authorServiceImplementation.getAuthorById(anyLong())).willReturn(Optional.of(authorA));
            //when
            controller.getAuthorById(authorA.getId());
            //then
            then(authorServiceImplementation).should().getAuthorById(anyLong());
            mockMvc.perform(get("/api/v1/author/get/byid/" + authorA.getId()))
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        }
    }

    @Nested
    public class saveAuthorWithMainInformation{

        Author authorBeforeToCreate = new Author(
                "emailA",
                "nameA");

        Author authorAfterToCreate = new Author(
                2L,
                "emailA",
                "nameA");

        @Test
        void itShouldSaveAuthorHappyCase() throws Exception {
            //given
            given(authorServiceImplementation
                    .saveAuthorWithMainInformation(any(Author.class)))
                    .willReturn(authorAfterToCreate);
            //when
            controller.saveAuthorWithMainInformation(authorBeforeToCreate);
            //then
            then(authorServiceImplementation).should().saveAuthorWithMainInformation(any(Author.class));
            //mockMvc.perform(post("/api/v1/author/save"))
            //        .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        }
    }

    @Nested
    public class deleteAuthorById{

        Long id = 2L;
        String response = "OK";

        @Test
        void itShouldDeleteAuthorByIdHappyCase() throws Exception {
            //given
            given(authorServiceImplementation
                    .deleteAuthorById(anyLong()))
                    .willReturn(response);
            //when
            controller.deleteAuthorById(id);
            //then
            then(authorServiceImplementation).should().deleteAuthorById(anyLong());
            mockMvc.perform(delete("/api/v1/author/delete/byid/" + id))
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        }
    }

}