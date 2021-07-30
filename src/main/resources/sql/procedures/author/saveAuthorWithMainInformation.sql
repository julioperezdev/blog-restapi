CREATE PROCEDURE saveAuthorWithMainInformation
    @Name VARCHAR(200),
    @Email VARCHAR(200)
AS
BEGIN
INSERT INTO Author (name, email) VALUES (@Name, @Email);
END
BEGIN
SELECT * FROM Author WHERE name = @Name;
end
GO;