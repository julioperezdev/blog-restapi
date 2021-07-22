CREATE TABLE Category(
                         id INT IDENTITY(1,1),
                         name VARCHAR(200) NOT NULL UNIQUE,
                         PRIMARY KEY (id)
);