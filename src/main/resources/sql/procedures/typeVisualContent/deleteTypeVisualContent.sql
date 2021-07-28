CREATE PROCEDURE deleteTypeVisualContentById
    @Id INT
AS
BEGIN
DELETE FROM TypeVisualContent where id = @Id
END
BEGIN
SELECT * FROM TypeVisualContent WHERE id = @Id;
end
GO;