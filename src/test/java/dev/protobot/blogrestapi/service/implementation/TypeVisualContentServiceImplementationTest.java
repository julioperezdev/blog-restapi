package dev.protobot.blogrestapi.service.implementation;

import dev.protobot.blogrestapi.helper.shared.CheckIfNullOrEmptyString;
import dev.protobot.blogrestapi.helper.shared.CheckIfNullOrZeroLong;
import dev.protobot.blogrestapi.helper.shared.CheckIfStringHaveNumber;
import dev.protobot.blogrestapi.helper.shared.ConvertStringToLowerCase;
import dev.protobot.blogrestapi.model.TypeVisualContent;
import dev.protobot.blogrestapi.repository.TypeVisualContentRepository;
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
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class TypeVisualContentServiceImplementationTest {

    @Mock
    CheckIfNullOrEmptyString checkIfNullOrEmptyString;

    @Mock
    CheckIfNullOrZeroLong checkIfNullOrZeroLong;

    @Mock
    CheckIfStringHaveNumber checkIfStringHaveNumber;

    @Mock
    ConvertStringToLowerCase convertStringToLowerCase;

    @Mock
    TypeVisualContentRepository typeVisualContentRepository;

    @InjectMocks
    TypeVisualContentServiceImplementation service;

    @Nested
    public class getAllTypeVisualContentCases{

        @Test
        void itShouldGetAllTypeVisualContentHappyCase() {
            //given
            List<TypeVisualContent> allTypeVisualContent = new ArrayList<>();
            allTypeVisualContent.add(new TypeVisualContent("image"));
            allTypeVisualContent.add(new TypeVisualContent("video"));

            given(typeVisualContentRepository.getAllTypeVisualContent()).willReturn(allTypeVisualContent);

            //when
            List<TypeVisualContent> response = service.getAllTypeVisualContent();

            //then
            then(typeVisualContentRepository).should().getAllTypeVisualContent();
            then(typeVisualContentRepository).shouldHaveNoMoreInteractions();
            assertEquals(2, response.size());



        }
    }

    @Nested
    public class getTypeVisualContentByIdCases{

        @Test
        void itShouldGetTypeVisualContentByIdHappyCase() {
            //given
            TypeVisualContent modelA = new TypeVisualContent(1l,"image");
            given(typeVisualContentRepository.getTypeVisualContentById(anyLong())).willReturn(Optional.of(modelA));
            //when
            Optional<TypeVisualContent> response = service.getTypeVisualContentById(modelA.getId());
            //then
            then(typeVisualContentRepository).should().getTypeVisualContentById(anyLong());
            then(typeVisualContentRepository).shouldHaveNoMoreInteractions();

        }

    }

    @Nested
    public class saveTypeVisualContent {

        @Test
        void itShouldSaveTypeVisualContentHappyCase() {
            //given
            TypeVisualContent typeVisualContentBeforeToSave = new TypeVisualContent("image");
            TypeVisualContent typeVisualContentAfterToSave = new TypeVisualContent(1l,"image");
            given(typeVisualContentRepository.saveTypeVisualContent(anyString())).willReturn(any(TypeVisualContent.class));
            //when
            service.saveTypeVisualContent(new TypeVisualContent());
            //then
            then(typeVisualContentRepository).should().saveTypeVisualContent(anyString());
            then(typeVisualContentRepository).shouldHaveNoMoreInteractions();
        }
    }

    @Nested
    public class deleteTypeVisualContentByIdCases{

        @Test
        void itShouldDeleteTypeVisualContentByIdHappyCase() {
            //given
            Long idToDelete = 1L;
            given(typeVisualContentRepository.deleteTypeVisualContentById(anyLong())).willReturn("");
            //when
            service.deleteTypeVisualContentById(idToDelete);
            //then
            then(typeVisualContentRepository).should().deleteTypeVisualContentById(anyLong());
            then(typeVisualContentRepository).shouldHaveNoMoreInteractions();

        }
    }

}