CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(20) NOT NULL,
    mobile_number BIGINT NOT NULL,
    is_active BOOLEAN DEFAULT TRUE
);

select * from users;

INSERT INTO users (name, email, password, mobile_number)
VALUES ('saranya', 'saranya@gmail.com', 'saranya@123', 1234567898),
       ('soundarya', 'sound@gmail.com', 'sound@123', 9876543212);
select * from users;

CREATE TABLE category (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) NOT NULL
);

INSERT INTO category (name)
values('face care'),('hair care'),('body care');
select * from category;


CREATE TABLE products(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(150) NOT NULL,
description TEXT NOT NULL,
product_weight VARCHAR(20) NOT NULL,
price DECIMAL (10,2),
ingredients TEXT NOT NULL,
benefits TEXT NOT NULL,
how_to_use TEXT NOT NULL,
self_life TEXT NOT NULL,
category_id INT,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
modified_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
FOREIGN KEY (category_id) REFERENCES category(id)
);

INSERT INTO products(name,category_id, description, product_weight, price, ingredients, benefits, how_to_use, self_life)
values('saffron gel',1, 'This gel is a natural skin brightener which will help get a more uniform & brighter complexion. It slowly evens out the skin tone by eliminating age spots, scars, & melisma. For a younger & bright looking skin, use regularly.', '100ml', 120,'Pure kashmiri saffron with aloe vera gel','It calms your skin and makes your skin supple and plumpy','Use twice a day for better result after face wash','3 months');
select * from products;
