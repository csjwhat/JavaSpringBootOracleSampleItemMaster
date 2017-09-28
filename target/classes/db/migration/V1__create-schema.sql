-- CREATE TABLE ITEMS(
--  item_id INT PRIMARY KEY AUTO_INCREMENT,
--  item_name VARCHAR(50),
--  item_property1 VARCHAR(50),
--  item_property2 VARCHAR(50),
--  item_property3 VARCHAR(50),
--  register_User VARCHAR(30),
--  register_Date VARCHAR(50));

CREATE TABLE ITEMS(
 item_id INT PRIMARY KEY,
 item_name VARCHAR(50),
 item_property1 VARCHAR(50),
 item_property2 VARCHAR(50),
 item_property3 VARCHAR(50),
 register_User VARCHAR(30),
 register_Date VARCHAR(50));


 CREATE SEQUENCE itemIdSeq;


-- create or replace TRIGGER P0stgres.itemIdTrig BEFORE INSERT ON P0stgres.ITEMS FOR EACH ROW
--BEGIN
--   SELECT P0stgres.itemIdSeq.NEXTVAL
--   INTO :new.item_id
--   FROM DUAL;
--END;