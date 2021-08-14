package dev.protobot.blogrestapi.service.implementation;

import dev.protobot.blogrestapi.model.Author;
import dev.protobot.blogrestapi.repository.AuthorRepository;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.util.Matrix;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;

@Service
public class PdfMakerServiceImplementation {


    private final AuthorRepository authorRepository;

    public PdfMakerServiceImplementation(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

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
        //File file = new File("Protobot2.png");
        //PDPageContentStream contentStream = new PDPageContentStream(document, blankPage);
        PDImageXObject image = PDImageXObject.createFromFile("Protobot2.png", document);
        image.setHeight(300);
        image.setWidth(300);
        //contentStream.drawImage(image, 0, 0);
        //contentStream.close();

        PDPageContentStream content = new PDPageContentStream(document, blankPage);

        content.beginText();
        content.setFont(PDType1Font.HELVETICA,26);
        content.newLineAtOffset(250, 750);
        content.showText("Registration Form");
        content.endText();
        content.drawImage(image, 0,0);

        content.close();


        // Save the newly created document
        document.save("8BlankPage.pdf");

        // finally make sure that the document is properly
        document.close();
    }

    public void createPdfWithHorizantalImageAndText() throws IOException, URISyntaxException {
        // Create a new empty document
        PDDocument document = new PDDocument();

        // Create a new blank page and add it to the document
        PDPage blankPage = new PDPage();
        document.addPage( blankPage );
        blankPage.setRotation(90);
        float height = blankPage.getMediaBox().getHeight();
        float width = blankPage.getMediaBox().getWidth();
        System.out.println(height);
        System.out.println(width);

        PDImageXObject image = PDImageXObject.createFromFile("Protobot2.png", document);
        image.setHeight(100);
        image.setWidth(100);


        PDPageContentStream content = new PDPageContentStream(document, blankPage);

        content.transform(Matrix.getRotateInstance(Math.toRadians(90),0,0));
        content.beginText();
        content.setFont(PDType1Font.HELVETICA,26);
        content.newLineAtOffset(100, -30);
        content.showText("Registration Form");
        content.newLine();
        content.newLineAtOffset(100, -50);
        content.showText("Registration For2");
        content.newLine();
        content.newLineAtOffset(0, -50);
        content.showText("Registration For3");

        content.endText();


        content.drawImage(image, width/2,-600);

        content.close();

        // Save the newly created document
        document.save("12BlankPage.pdf");

        // finally make sure that the document is properly
        document.close();
    }

    public void createPdfWithBackgroundColor(Long id) throws IOException, URISyntaxException {
        // Create a new empty document
        Optional<Author> authorById = authorRepository.getAuthorById(id);
        PDDocument document = new PDDocument();

        // Create a new blank page and add it to the document
        PDPage blankPage = new PDPage();
        document.addPage( blankPage );
        blankPage.setRotation(90);
        float height = blankPage.getMediaBox().getHeight();
        float width = blankPage.getMediaBox().getWidth();
        System.out.println(height);
        System.out.println(width);

        PDImageXObject image = PDImageXObject.createFromFile("Protobot2.png", document);
        image.setHeight(100);
        image.setWidth(100);

        PDFont boldFont = PDType1Font.HELVETICA_BOLD;
        PDFont normalFont = PDType1Font.HELVETICA;

        int fontSize = 16;
        int marginTop = 30;

        float titleWidth = boldFont.getStringWidth("PROTOBOT") / 1000 * fontSize;
        float titleHeight = boldFont.getFontDescriptor().getFontBoundingBox().getHeight() / 1000 * fontSize;

        PDPageContentStream content = new PDPageContentStream(document, blankPage);

        content.transform(Matrix.getRotateInstance(Math.toRadians(90),0,0));
        content.beginText();
        content.setFont(boldFont,26);
        //content.newLineAtOffset((blankPage.getMediaBox().getWidth() - titleWidth) / 2, blankPage.getMediaBox().getHeight() - marginTop - titleHeight);
        content.newLineAtOffset(310, -50);
        content.showText("PROTOBOT");
        content.newLine();
        content.setFont(PDType1Font.HELVETICA,14);
        content.newLineAtOffset(0, -30);
        content.showText("Certifica que el estudiante");
        content.newLine();
        content.setFont(boldFont,30);
        content.newLineAtOffset(0, -50);
        content.showText(authorById.get().getFullName());
        content.newLine();
        content.setFont(PDType1Font.HELVETICA,16);
        content.newLineAtOffset(0, -50);
        content.showText("Ha finalizado el curso de");
        content.newLine();
        content.newLineAtOffset(0, -50);
        content.setFont(PDType1Font.HELVETICA,10);
        content.showText(authorById.get().getEmail());

        content.endText();

        content.drawImage(image, 355,-600);

        content.close();

        // Save the newly created document
        document.save("/home/protobot/14BlankPage.pdf");

        // finally make sure that the document is properly
        document.close();
    }
}