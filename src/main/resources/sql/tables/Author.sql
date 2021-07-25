CREATE TABLE Author(
                       id INT IDENTITY(1,1),
                       name VARCHAR(200) NOT NULL,
                       email VARCHAR(200) NOT NULL UNIQUE,
                       imageUrl VARCHAR(300),
                       publicId VARCHAR(300),
                       PRIMARY KEY (id)
);