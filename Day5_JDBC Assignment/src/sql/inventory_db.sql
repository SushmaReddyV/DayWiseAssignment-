CREATE DATABASE IF NOT EXISTS inventory_db;
USE inventory_db;

CREATE TABLE IF NOT EXISTS products (
    product_id INT PRIMARY KEY,
    product_name VARCHAR(100),
    quantity INT,
    price DECIMAL(10,2)
);