CREATE TABLE ImagePresentation(
                                  idPost INT,
                                  imageUrl VARCHAR(300),
                                  publicId VARCHAR(300),
                                  PRIMARY KEY (idPost),
                                  FOREIGN KEY (idPost) REFERENCES Post(id)
);