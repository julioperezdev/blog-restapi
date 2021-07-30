CREATE PROCEDURE deleteAuthorById
    @Id INT
AS
BEGIN
DELETE FROM Author where id = @Id
END
BEGIN
SELECT name FROM Author WHERE id = @Id;
end
GO;