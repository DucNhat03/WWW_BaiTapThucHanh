
create database shoppingcart

CREATE TABLE product (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    image VARCHAR(255),
    quantity INT,
    price DOUBLE
);