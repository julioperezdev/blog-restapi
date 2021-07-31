package dev.protobot.blogrestapi.service.implementation;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class PdfMakerServiceImplementation {

    public void createPdf() throws IOException {
        // Create a new empty document
        PDDocument document = new PDDocument();

        // Create a new blank page and add it to the document
        PDPage blankPage = new PDPage();
        document.addPage( blankPage );

        // Save the newly created document
        document.save("1BlankPage.pdf");

        // finally make sure that the document is properly
        // closed.
        document.close();
    }

    public void createPdfWithText() throws IOException {
        // Create a new empty document
        PDDocument document = new PDDocument();

        // Create a new blank page and add it to the document
        PDPage blankPage = new PDPage();
        document.addPage( blankPage );

        PDPageContentStream content = new PDPageContentStream(document, blankPage);

        content.beginText();
        content.setFont(PDType1Font.HELVETICA,26);
        content.newLineAtOffset(250, 750);
        content.showText("Registration Form");
        content.endText();

        content.close();

        // Save the newly created document
        document.save("3BlankPage.pdf");

        // finally make sure that the document is properly
        // closed.
        document.close();
    }

    public void createPdfWithText2() throws IOException {
        String name = "Julio";
        // Create a new empty document
        PDDocument document = new PDDocument();

        // Create a new blank page and add it to the document
        PDPage blankPage = new PDPage();
        document.addPage( blankPage );

        PDPageContentStream content = new PDPageContentStream(document, blankPage);

        content.beginText();
        content.setFont(PDType1Font.HELVETICA,26);
        content.newLineAtOffset(250, 750);
        content.showText("Registration Form");
        content.endText();

        content.beginText();
        content.setFont(PDType1Font.HELVETICA,26);
        content.newLineAtOffset(250, 700);
        content.showText("Name: " + name);
        content.endText();

        content.close();

        // Save the newly created document
        document.save("4BlankPage.pdf");

        // finally make sure that the document is properly
        // closed.
        document.close();
    }


    public void createPdfWithImage() throws IOException, URISyntaxException {
        // Create a new empty document
        PDDocument document = new PDDocument();

        // Create a new blank page and add it to the document
        PDPage blankPage = new PDPage();
        document.addPage( blankPage );

        //Path path = Paths.get(ClassLoader.getSystemResource("Protobot2.png").toURI());
        File file = new File("Protobot2.png");
        PDPageContentStream contentStream = new PDPageContentStream(document, blankPage);
        PDImageXObject image = PDImageXObject.createFromFile("Protobot2.png", document);
        contentStream.drawImage(image, 0, 0);
        contentStream.close();

        // Save the newly created document
        document.save("5BlankPage.pdf");



        // finally make sure that the document is properly
        document.close();
    }

    public void createPdfWithImageAndText() throws IOException, URISyntaxException {
        // Create a new empty document
        PDDocument document = new PDDocument();

        // Create a new blank page and add it to the document
        PDPage blankPage = new PDPage();
        document.addPage( blankPage );

        //Path path = Paths.get(ClassLoader.getSystemResource("Protobot2.png").toURI());
        File file = new File("Protobot2.png");
        PDPageContentStream contentStream = new PDPageContentStream(document, blankPage);
        PDImageXObject image = PDImageXObject.createFromFile("Protobot2.png", document);
        contentStream.drawImage(image, 0, 0);
        contentStream.close();

        PDPageContentStream content = new PDPageContentStream(document, blankPage);

        content.beginText();
        content.setFont(PDType1Font.HELVETICA,26);
        content.newLineAtOffset(250, 750);
        content.showText("Registration Form");
        content.endText();

        content.close();


        // Save the newly created document
        document.save("7BlankPage.pdf");



        // finally make sure that the document is properly
        document.close();
    }




}
