CREATE TABLE AuthorCertificate(
                                  id INT IDENTITY(1,1),
                                  code VARCHAR(200) NOT NULL,
                                  idAuthor INT NOT NULL UNIQUE,
                                  PRIMARY KEY (id),
                                  FOREIGN KEY (idAuthor) REFERENCES Author(id)

);