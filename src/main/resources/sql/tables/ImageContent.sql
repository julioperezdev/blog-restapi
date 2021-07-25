CREATE TABLE ImageContent(
                             idPost INT,
                             idTypeVisualContent INT,
                             imageUrl VARCHAR(300),
                             publicId VARCHAR(300),
                             PRIMARY KEY (idPost),
                             FOREIGN KEY (idPost) REFERENCES Post(id),
                             FOREIGN KEY (idTypeVisualContent) REFERENCES TypeVisualContent(id)
);