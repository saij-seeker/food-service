CREATE TABLE IF NOT EXISTS foodservice_test
(
 id          bigint NOT NULL AUTO_INCREMENT ,
 name        varchar(50) NULL ,
 created_at datetime NOT NULL,
 updated_at datetime NOT NULL,

 PRIMARY KEY (id)
) AUTO_INCREMENT=1;