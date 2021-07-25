CREATE TABLE PostLikesUser(
                              id INT IDENTITY (1,1),
                              idPost INT NOT NULL,
                              idUser INT NOT NULL,
                              PRIMARY KEY (id),
                              FOREIGN KEY (idPost) REFERENCES Post(id),
                              FOREIGN KEY (idUser) REFERENCES Users(id)
);