package dev.protobot.blogrestapi.controller;

import dev.protobot.blogrestapi.model.TypeVisualContent;
import dev.protobot.blogrestapi.service.implementation.TypeVisualContentServiceImplementation;
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
class TypeVisualContentControllerTest {

    @Mock
    TypeVisualContentServiceImplementation typeVisualContentServiceImplementation;

    @InjectMocks
    TypeVisualContentController controller;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Nested
    public class itShouldGetAllTypeVisualContentCases{

        List<TypeVisualContent> allTypeVisualContent = new ArrayList<>();
        TypeVisualContent typeVisualContentA = new TypeVisualContent(1L, "Java");
        TypeVisualContent typeVisualContentB = new TypeVisualContent(2L, "Sql");
        TypeVisualContent typeVisualContentC = new TypeVisualContent(3L, "Docker");

        @BeforeEach
        void setUp() {
            allTypeVisualContent.add(typeVisualContentA);
            allTypeVisualContent.add(typeVisualContentB);
            allTypeVisualContent.add(typeVisualContentC);
        }

        @Test
        void itShouldGetAllTypeVisualContentHappyCase() throws Exception {
            //given
            given(typeVisualContentServiceImplementation.getAllTypeVisualContent()).willReturn(allTypeVisualContent);
            //when
            controller.getAllTypeVisualContent();
            //then
            then(typeVisualContentServiceImplementation).should().getAllTypeVisualContent();
            assertEquals(3, allTypeVisualContent.size());
            mockMvc.perform(get("/type-visual-content/getall"))
                    //.andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    //.andExpect(jsonPath("$.status", is("OK")))
                    .andExpect(jsonPath("$.body", hasSize(3)));
        }
    }

    @Nested
    public class itShouldGetTypeVisualContentByIdCases{

        Long idA = 1L;

        TypeVisualContent typeVisualContentA = new TypeVisualContent(1L, "Java");

        @BeforeEach
        void setUp() {
        }

        @Test
        void itShouldGetTypeVisualContentByIdHappyCase() throws Exception {
            //given
            given(typeVisualContentServiceImplementation.getTypeVisualContentById(anyLong())).willReturn(Optional.of(typeVisualContentA));
            //when
            controller.getTypeVisualContentById(idA);
            //then
            then(typeVisualContentServiceImplementation).should().getTypeVisualContentById(anyLong());
            //assertEquals(3, allTypeVisualContent.size());
            mockMvc.perform(get("/api/v1/type-visual-content/get/byid/1"))
                    //.andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON));
                    //.andExpect(jsonPath("$.status", is("OK")));
        }
    }

    @Nested
    public class itShouldSaveTypeVisualContentCase{

        TypeVisualContent toCreateTypeVisualContent = new TypeVisualContent("java");
        TypeVisualContent createdTypeVisualContent = new TypeVisualContent(1L,"java");

        @Test
        void itShouldSaveTypeVisualContentHappyCase() throws Exception {
            //given
            given(typeVisualContentServiceImplementation.saveTypeVisualContent(toCreateTypeVisualContent))
                    .willReturn(createdTypeVisualContent);

            //when
            controller.saveTypeVisualContent(toCreateTypeVisualContent);

            //then
            then(typeVisualContentServiceImplementation).should().saveTypeVisualContent(any(TypeVisualContent.class));
//            mockMvc.perform(post("/api/v1/type-visual-content/save"))
//                    .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        }
    }

    @Nested
    public class itShouldDeleteTypeVisualContentByIdCase{

        @Test
        void itShouldTypeVisualContentByIdHappyCase() throws Exception {
            //given
            Long id = 1L;
            String responseService = "OK";
            given(typeVisualContentServiceImplementation.deleteTypeVisualContentById(anyLong())).willReturn(responseService);

            //when
            controller.deleteTypeVisualContentById(id);

            //then
            then(typeVisualContentServiceImplementation).should().deleteTypeVisualContentById(id);
            mockMvc.perform(delete("/api/v1/type-visual-content/delete/byid/"+id))
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        }
    }




}