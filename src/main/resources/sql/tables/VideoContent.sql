CREATE TABLE VideoContent(
                             idPost INT,
                             idTypeVisualContent INT,
                             videoUrl VARCHAR(300),
                             PRIMARY KEY (idPost),
                             FOREIGN KEY (idPost) REFERENCES Post(id),
                             FOREIGN KEY (idTypeVisualContent) REFERENCES TypeVisualContent(id)
);