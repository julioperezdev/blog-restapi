CREATE TABLE Users(
                      id INT IDENTITY(1,1),
                      email VARCHAR(200) NOT NULL UNIQUE,
                      PRIMARY KEY (id)
);