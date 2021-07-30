package dev.protobot.blogrestapi.controller;

import dev.protobot.blogrestapi.dto.response.RestResponse;
import dev.protobot.blogrestapi.model.TypeVisualContent;
import dev.protobot.blogrestapi.service.TypeVisualContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/type-visual-content")
public class TypeVisualContentController {


    private final TypeVisualContentService typeVisualContentService;

    @Autowired
    public TypeVisualContentController(TypeVisualContentService typeVisualContentService) {
        this.typeVisualContentService = typeVisualContentService;
    }


    @GetMapping("/getall")
    public RestResponse<List<TypeVisualContent>> getAllTypeVisualContent() {
        List<TypeVisualContent> allTypeVisualContent = typeVisualContentService.getAllTypeVisualContent();
        return new RestResponse<>(HttpStatus.ACCEPTED, allTypeVisualContent);
    }

    @GetMapping("/get/byid/{id}")
    public RestResponse<Optional<TypeVisualContent>> getTypeVisualContentById(@PathVariable Long id) {
        Optional<TypeVisualContent> typeVisualContent = typeVisualContentService.getTypeVisualContentById(id);
        return new RestResponse<>(HttpStatus.ACCEPTED, typeVisualContent);
    }

    @PostMapping("/save")
    public RestResponse<TypeVisualContent> saveTypeVisualContent(@RequestBody TypeVisualContent typeVisualContent) {
        TypeVisualContent typeVisualContentCreated = typeVisualContentService.saveTypeVisualContent(typeVisualContent);
        return new RestResponse<>(HttpStatus.CREATED, typeVisualContentCreated);
    }

    @DeleteMapping("/delete/byid/{id}")
    public RestResponse<String> deleteTypeVisualContentById(@PathVariable Long id) {
        String responseService = typeVisualContentService.deleteTypeVisualContentById(id);
        return new RestResponse<>(HttpStatus.OK, responseService);
    }
}
