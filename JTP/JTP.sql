CREATE TABLE userDTO(
id VARCHAR2(10),
name VARCHAR2(15),
cash NUMBER,
point NUMBER
)


CREATE TABLE buybook(
userid VARCHAR2(10),
buybookcode NUMBER
)


CREATE TABLE book(
code NUMBER,
name VARCHAR2(30),
genre VARCHAR2(15),
price NUMBER
)

CREATE TABLE fkgn(
fkgn VARCHAR2(15)
)

INSERT INTO fkgn VALUES ('외국어')
INSERT INTO fkgn VALUES ('인문학')
INSERT INTO fkgn VALUES ('자기계발')
INSERT INTO fkgn VALUES ('경제경영')
INSERT INTO fkgn VALUES ('만화')
INSERT INTO fkgn VALUES ('어린이')
INSERT INTO fkgn VALUES ('요리')
INSERT INTO fkgn VALUES ('역사')
INSERT INTO fkgn VALUES ('여행')
INSERT INTO fkgn VALUES ('예술')
INSERT INTO fkgn VALUES ('소설')
INSERT INTO fkgn VALUES ('에세이')



ALTER TABLE userDTO ADD CONSTRAINT pk_userDTO_id PRIMARY KEY(id)
ALTER TABLE book ADD CONSTRAINT pk_book_id PRIMARY KEY(code)
ALTER TABLE fkgn ADD CONSTRAINT pk_fkgn_id PRIMARY KEY(fkgn)
ALTER TABLE book ADD CONSTRAINT fk_book_genre FOREIGN key(genre) REFERENCES fkgn(fkgn)

SELECT * FROM userDTO
SELECT * FROM book



INSERT INTO book VALUES (1,'나미야 잡화점의 기적','소설',12000)
INSERT INTO book VALUES (2,'무지개 곶의 찻집','소설',8000)
INSERT INTO book VALUES (3,'신더','소설',13000)
