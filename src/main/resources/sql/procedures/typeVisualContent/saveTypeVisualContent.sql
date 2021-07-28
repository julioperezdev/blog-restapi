CREATE PROCEDURE saveTypeVisualContent
    @Name VARCHAR(200)
AS
BEGIN
INSERT INTO TypeVisualContent (name) VALUES (@Name);
END
BEGIN
SELECT * FROM TypeVisualContent WHERE name = @Name;
end
GO;