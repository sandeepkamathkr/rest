
drop table USER;
CREATE TABLE USER(
   ID INT NOT NULL,
   NAME VARCHAR(50) NOT NULL,
   AUTHOR VARCHAR(20) NOT NULL,
   CREATION_DATE DATE,
);
commit;
insert into USER (ID,NAME,AUTHOR,CREATION_DATE)  values (1,'Sandeep Kamath','sandy2friends', CURRENT_DATE());
insert into USER (ID,NAME,AUTHOR,CREATION_DATE) values (2,'Reshma Kamath','sandy2friends', CURRENT_DATE());
