CREATE PROCEDURE deletePostById
    @Id INT
AS
BEGIN
DELETE FROM Post where id = @Id
END
BEGIN
SELECT * FROM Post WHERE id = @Id;
end
GO;