package dev.protobot.blogrestapi.service.implementation;

import dev.protobot.blogrestapi.helper.shared.CheckIfNullOrEmptyString;
import dev.protobot.blogrestapi.helper.shared.CheckIfNullOrZeroLong;
import dev.protobot.blogrestapi.helper.shared.CheckIfStringHaveNumber;
import dev.protobot.blogrestapi.helper.shared.ConvertStringToLowerCase;
import dev.protobot.blogrestapi.model.Author;
import dev.protobot.blogrestapi.repository.AuthorRepository;
import org.junit.jupiter.api.BeforeEach;
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
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class AuthorServiceImplementationTest {

    @Mock
    CheckIfNullOrEmptyString checkIfNullOrEmptyString;

    @Mock
    CheckIfNullOrZeroLong checkIfNullOrZeroLong;

    @Mock
    CheckIfStringHaveNumber checkIfStringHaveNumber;

    @Mock
    ConvertStringToLowerCase convertStringToLowerCase;

    @Mock
    AuthorRepository authorRepository;

    @InjectMocks
    AuthorServiceImplementation service;

    @Nested
    public class getAllAuthors{
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
        void itShouldGetAllAuthorHappyCase() {
            //given
            given(authorRepository.getAllAuthors()).willReturn(allAuthor);
            //when
            List<Author> authorsResponse = service.getAllAuthors();
            //then
            then(authorRepository).should().getAllAuthors();
            then(authorRepository).shouldHaveNoMoreInteractions();
            assertEquals(1, authorsResponse.size());
        }
    }

    @Nested
    public class getAuthorById{
        Author authorA = new Author(
                2L,
                "emailA",
                "nameA",
                "urlA",
                "publicA");

        @Test
        void itShouldGetAuthorByIdHappyCase(){
            //given
            given(authorRepository.getAuthorById(anyLong())).willReturn(Optional.of(authorA));
            //when
            service.getAuthorById(authorA.getId());
            //then
            then(authorRepository).should().getAuthorById(authorA.getId());
            then(authorRepository).shouldHaveNoMoreInteractions();
            //then(checkIfNullOrZeroLong).should().check(authorA.getId());
            //then(checkIfNullOrZeroLong).shouldHaveNoMoreInteractions();
        }
    }

    @Nested
    public class saveAuthorWithMainInformation{

        Author authorBeforeToCreate = new Author(
                "emailA",
                "emailA");

        Author authorAfterToCreate = new Author(
                2L,
                "emailA",
                "emailA");

        @Test
        void itShouldSaveAuthorHappyCase(){
            //given
            given(convertStringToLowerCase.convert(anyString()))
                    .willReturn(authorBeforeToCreate.getFullName());
            given(authorRepository.saveAuthorWithMainInformation(
                    authorBeforeToCreate.getFullName(),
                    authorBeforeToCreate.getEmail()))
                    .willReturn(authorAfterToCreate);
            //when
            service.saveAuthorWithMainInformation(authorBeforeToCreate);
            //then
            then(checkIfNullOrEmptyString).should(times(2)).check(anyString());
            then(checkIfNullOrEmptyString).shouldHaveNoMoreInteractions();
            then(checkIfStringHaveNumber).should(times(2)).check(anyString());
            then(checkIfStringHaveNumber).shouldHaveNoMoreInteractions();
            then(convertStringToLowerCase).should(times(2)).convert(authorBeforeToCreate.getFullName());
            then(convertStringToLowerCase).shouldHaveNoMoreInteractions();
            then(authorRepository).should().saveAuthorWithMainInformation(
                    authorBeforeToCreate.getFullName(),
                    authorBeforeToCreate.getEmail());
            then(authorRepository).shouldHaveNoMoreInteractions();
        }
    }

    @Nested
    public class deleteAuthorById{

        Long id = 2L;
        String response = "OK";

        @Test
        void itShouldDeleteAuthorByIdHappyCase(){
            //given

            given(authorRepository.deleteAuthorById(anyLong())).willReturn(response);
            //when
            String responseService = service.deleteAuthorById(id);
            //then
            then(authorRepository).should().deleteAuthorById(anyLong());
            then(authorRepository).shouldHaveNoMoreInteractions();
            then(checkIfNullOrZeroLong).should().check(anyLong());
            then(checkIfNullOrZeroLong).shouldHaveNoMoreInteractions();

        }
    }




}