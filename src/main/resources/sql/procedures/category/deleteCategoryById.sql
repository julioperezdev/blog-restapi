CREATE PROCEDURE deleteCategoryById
    @Id INT
AS
BEGIN
DELETE FROM Category where id = @Id
END
BEGIN
SELECT * FROM Category WHERE id = @Id;
end
GO;