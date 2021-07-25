CREATE PROCEDURE saveCategory
    @Name VARCHAR(200)
AS
BEGIN
INSERT INTO Category (name) VALUES (@Name);
END
BEGIN
SELECT * FROM Category WHERE name = @Name;
end
GO;