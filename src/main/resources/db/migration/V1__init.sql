CREATE TABLE IF NOT EXISTS foodservice_test
(
 id          bigint NOT NULL AUTO_INCREMENT ,
 name        varchar(50) NULL ,
 created_at datetime NOT NULL,
 updated_at datetime NOT NULL,

 PRIMARY KEY (id)
) AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS restaurants
(
id      bigint NOT NULL AUTO_INCREMENT ,
name    varchar(50) NOT NULL,
address varchar(100) NOT NULL,

PRIMARY KEY(id)
)AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS items
(
id            bigint NOT NULL AUTO_INCREMENT,
name          varchar(50) NOT NULL ,
price         bigint  NOT NULL ,
restaurant_id bigint,

PRIMARY KEY(id),
FOREIGN KEY (restaurant_id) REFERENCES restaurants(id)
)AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS users
(
id             bigint NOT NULL AUTO_INCREMENT ,
name           varchar(50) NOT NULL,
address        varchar(50) NOT NULL,
mail_id        varchar(50) NOT NULL,
contact        varchar(50) NOT NULL,

PRIMARY KEY(id)
)AUTO_INCREMENT=1;


CREATE TABLE IF NOT EXISTS orders
(
id       bigint NOT NULL AUTO_INCREMENT,
item_id  bigint,
quantity bigint NOT NULL,
amount   bigint NOT NULL,
user_id  bigint,

PRIMARY KEY(id),
FOREIGN KEY (item_id) REFERENCES items(id),
FOREIGN KEY (user_id) REFERENCES users(id)
)AUTO_INCREMENT=1;
