package dev.protobot.blogrestapi.controller;

import dev.protobot.blogrestapi.dto.response.RestResponse;
import dev.protobot.blogrestapi.model.Author;
import dev.protobot.blogrestapi.service.AuthorService;
import dev.protobot.blogrestapi.service.implementation.PdfMakerServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/author")
public class AuthorController {

    private final AuthorService authorService;

    private final PdfMakerServiceImplementation pdfMakerServiceImplementation;

    @Autowired
    public AuthorController(AuthorService authorService, PdfMakerServiceImplementation pdfMakerServiceImplementation) {
        this.authorService = authorService;
        this.pdfMakerServiceImplementation = pdfMakerServiceImplementation;
    }


    @GetMapping("/getall")
    public RestResponse<List<Author>> getAllAuthors() {
        List<Author> allAuthors = authorService.getAllAuthors();
        return new RestResponse<>(HttpStatus.ACCEPTED, allAuthors);
    }

    @GetMapping("/get/byid/{id}")
    public RestResponse<Optional<Author>> getAuthorById(@PathVariable Long id) {
        Optional<Author> authorById = authorService.getAuthorById(id);
        return new RestResponse<>(HttpStatus.ACCEPTED, authorById);
    }

    @PostMapping("/save")
    public RestResponse<Author> saveAuthorWithMainInformation(@RequestBody Author author) {
        Author authorSaved = authorService.saveAuthorWithMainInformation(author);
        return new RestResponse<>(HttpStatus.CREATED, authorSaved);
    }

    @DeleteMapping("/delete/byid/{id}")
    public RestResponse<String> deleteAuthorById(@PathVariable Long id) {
        String response = authorService.deleteAuthorById(id);
        return new RestResponse<>(HttpStatus.ACCEPTED, response);
    }

    @PostMapping("/pdf/{id}")
    public void makePdf(@PathVariable Long id) throws IOException, URISyntaxException {
        pdfMakerServiceImplementation.createPdfWithBackgroundColor(id);
    }
}
