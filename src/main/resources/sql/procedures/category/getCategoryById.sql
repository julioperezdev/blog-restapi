CREATE PROCEDURE getCategoryById
    @Id INT
AS
BEGIN
SELECT * FROM Category WHERE id = @Id;
end
GO;