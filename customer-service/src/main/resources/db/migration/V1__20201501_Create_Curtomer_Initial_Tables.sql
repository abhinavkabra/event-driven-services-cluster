CREATE TABLE IF NOT EXISTS CUSTOMER (
  id                INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  first_name        VARCHAR(100),
  last_name         VARCHAR(100),
  email_id          VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS CUSTOMER_ORDER (
  id                INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  request_id        varchar(64),
  customer_id       INT,
  status            VARCHAR(100),
  item_id           VARCHAR (64),
  item_qty          INT
);

INSERT INTO CUSTOMER (first_name,last_name,email_id) values ('Admin_First', 'Admin_Last', 'admin@test.co.in');