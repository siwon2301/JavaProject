DELETE FROM member 
COMMIT

SELECT * FROM ebookMember

CREATE TABLE ebook(
bCode NUMBER,
bName VARCHAR2(60),
bGenre VARCHAR2(60),
bprice NUMBER,
bpoint NUMBER,
bAvailable VARCHAR2(60)
)

SELECT * FROM ebook
DELETE FROM ebookList

