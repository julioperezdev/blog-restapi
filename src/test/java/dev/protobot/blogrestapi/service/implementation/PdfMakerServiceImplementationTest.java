package dev.protobot.blogrestapi.service.implementation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PdfMakerServiceImplementationTest {

    @InjectMocks
    PdfMakerServiceImplementation service;

    @Test
    void createBlankPage() throws IOException {
        service.createPdf();
    }

    @Test
    void createPageWithText() throws IOException {
        service.createPdfWithText();
    }

    @Test
    void createPageWithText2() throws IOException {
        service.createPdfWithText2();
    }

    @Test
    void createPageWithImage() throws IOException, URISyntaxException {
        service.createPdfWithImage();
    }

    @Test
    void createPageWithImageAndText() throws IOException, URISyntaxException {
        service.createPdfWithImageAndText();
    }

    @Test
    void createPageWithHorizontalImageAndText() throws IOException, URISyntaxException {
        service.createPdfWithHorizantalImageAndText();
    }

    @Test
    void createPageWithBackgroundColor() throws IOException, URISyntaxException {
        //String name = "Julio Ernesto Perez Viloria";
        //String email = "julio@email.com";
        Long id = 1L;
        service.createPdfWithBackgroundColor(id);
    }
}