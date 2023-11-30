CREATE DATABASE midterm_test;

USE midterm_test;

CREATE TABLE category (
    category_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (category_id)
);

CREATE TABLE orders (
    id INT NOT NULL AUTO_INCREMENT,
    total_selling_price INT,
    PRIMARY KEY (id)
);

CREATE TABLE order_product (
    order_id INT NOT NULL,
    product_id INT NOT NULL
);

CREATE TABLE product (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    image_name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    category_id INT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE roles (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT,
    email VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    password VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE user_role (
    user_id INT NOT NULL,
    role_id INT NOT NULL
);

INSERT INTO category (category_id, name) VALUES
(NULL, 'Milk tea'),
(NULL, 'Fruit tea'),
(NULL, 'Ice Cream'),
(NULL, 'Coffee');

INSERT INTO product (`id`, `name`, `image_name`, `description`, `price`, `category_id`) VALUES
(NULL, 'Trà sữa trân châu đường hổ', 'tra-sua-tran-chau-duong-den.jpg', 'Milk tea', '33', '1'),
(NULL, 'Trà sữa phô mai tươi', 'Tra-sua-pho-mai-tuoi.png', 'Milk tea', '40', '1'),
(NULL, 'Kem trân châu hoàng kim', 'kem-tran-chau-hoang-kim.jpg', 'Ice Cream', '25', '3'),
(NULL, 'Kem dâu tây', 'kem-dau-tay.jpg', 'Ice Cream', '25', '3'),
(NULL, 'Trà dâu tằm pha lê tuyết', 'Tra-Dau-Tam-Pha-Le-Tuyet.jpg', 'Fruit tea', '40', '2'),
(NULL, 'Cà phê sữa đá', 'ca-phe-sua.jpg', 'Coffee', '15', '4'),
(NULL, 'Cà phê đen đá', 'ca-phe-den.jpg', 'Coffee', '12', '4'),
(NULL, 'Trà dứa thạch konjac', 'tra-dua.jpg', 'Fruit tea', '30', '2');

INSERT INTO roles (id, name) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

INSERT INTO users (id, email, password, first_Name, last_Name) VALUES
(1, 'admin@gmail.com', '$2a$10$moTjfAVBJzNS32q7NPPVh.iAGDbZSkjZJBkdxT5ZLKQ3R1Vh/y9Fi', 'Nhan', 'Vo');

insert into user_role(user_id, role_id) values
(1,1),
(1,2);
