CREATE TABLE Post(
                     id INT IDENTITY(1,1),
                     title VARCHAR(300) NOT NULL UNIQUE,
                     dates DATETIME NOT NULL,
                     description VARCHAR(1699) NOT NULL UNIQUE,
                     idCategory INT NOT NULL,
                     idTypeVisualContent INT NOT NULL,
                     idAuthor INT NOT NULL,
                     PRIMARY KEY (id),
                     FOREIGN KEY (idTypeVisualContent) REFERENCES TypeVisualContent (id),
                     FOREIGN KEY (idCategory) REFERENCES Category(id),
                     FOREIGN KEY (idAuthor) REFERENCES Author(id)
);