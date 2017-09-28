CREATE TABLE users (
  user_name NVARCHAR2(30) NOT NULL PRIMARY KEY,
  encoded_password NVARCHAR2(255),
  user_role NVARCHAR2(5) NOT NULL,
  delete_flg NUMERIC(1));