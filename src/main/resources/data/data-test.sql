START TRANSACTION;
INSERT INTO customer (address, email, cust_name, phone) VALUES
('123 Customer St', 'customer1@example.com', 'Customer 1', '555-1111'),
('456 Customer St', 'customer2@example.com', 'Customer 2', '555-2222'),
('789 Customer St', 'customer3@example.com', 'Customer 3', '555-3333'),
('1234 Customer St', 'customer4@example.com', 'Customer 4', '555-4444'),
('5678 Customer St', 'customer5@example.com', 'Customer 5', '555-5555'),
('9876 Customer St', 'customer6@example.com', 'Customer 6', '555-6666'),
('5432 Customer St', 'customer7@example.com', 'Customer 7', '555-7777'),
('8765 Customer St', 'customer8@example.com', 'Customer 8', '555-8888'),
('2345 Customer St', 'customer9@example.com', 'Customer 9', '555-9999'),
('6789 Customer St', 'customer10@example.com', 'Customer 10', '555-0000'),
('4321 Customer St', 'customer11@example.com', 'Customer 11', '555-1234'),
('3456 Customer St', 'customer12@example.com', 'Customer 12', '555-2345'),
('7890 Customer St', 'customer13@example.com', 'Customer 13', '555-3456');
INSERT INTO employee (address, dob, email, full_name, phone, status) VALUES
('123 Employee St', '1990-01-15 08:00:00', 'employee1@example.com', 'John Doe', '555-1234', 1),
('456 Employee St', '1985-05-20 12:30:00', 'employee2@example.com', 'Jane Smith', '555-5678', 1),
('789 Employee St', '1995-09-10 09:15:00', 'employee3@example.com', 'Robert Johnson', '555-9876', 1),
('1111 Employee St', '1980-03-05 15:30:00', 'employee4@example.com', 'Michael Johnson', '555-1111', 1),
('2222 Employee St', '1975-07-10 10:45:00', 'employee5@example.com', 'Emily Brown', '555-2222', 1),
('3333 Employee St', '1992-11-20 09:00:00', 'employee6@example.com', 'Daniel Wilson', '555-3333', 1),
('4444 Employee St', '1987-08-15 14:15:00', 'employee7@example.com', 'Olivia Davis', '555-4444', 1),
('5555 Employee St', '1983-01-25 11:30:00', 'employee8@example.com', 'William Anderson', '555-5555', 1),
('6666 Employee St', '1998-04-02 08:45:00', 'employee9@example.com', 'Sophia Martinez', '555-6666', 1),
('7777 Employee St', '1979-09-12 16:00:00', 'employee10@example.com', 'Joseph Taylor', '555-7777', 1),
('8888 Employee St', '1989-12-30 12:15:00', 'employee11@example.com', 'Emma Garcia', '555-8888', 1),
('9999 Employee St', '1993-06-22 13:30:00', 'employee12@example.com', 'Alexander Hernandez', '555-9999', 1),
('0000 Employee St', '1997-02-14 10:00:00', 'employee13@example.com', 'Ava Miller', '555-0000', 1);
INSERT INTO product (description, manufacturer_name, name, status, unit) VALUES
('Product 1 Description', 'Manufacturer A', 'Product 1', 1, 'Piece'),
('Product 2 Description', 'Manufacturer B', 'Product 2', 1, 'Piece'),
('Product 3 Description', 'Manufacturer C', 'Product 3', 1, 'Piece'),
('Product 4 Description', 'Manufacturer D', 'Product 4', 1, 'Piece'),
('Product 5 Description', 'Manufacturer E', 'Product 5', 1, 'Piece'),
('Product 6 Description', 'Manufacturer F', 'Product 6', 1, 'Piece'),
('Product 7 Description', 'Manufacturer G', 'Product 7', 1, 'Piece'),
('Product 8 Description', 'Manufacturer H', 'Product 8', 1, 'Piece'),
('Product 9 Description', 'Manufacturer I', 'Product 9', 1, 'Piece'),
('Product 10 Description', 'Manufacturer J', 'Product 10', 1, 'Piece'),
('Product 11 Description', 'Manufacturer K', 'Product 11', 1, 'Piece'),
('Product 12 Description', 'Manufacturer L', 'Product 12', 1, 'Piece'),
('Product 13 Description', 'Manufacturer M', 'Product 13', 1, 'Piece');
INSERT INTO orders (order_date, cust_id, employee_id) VALUES
('2023-09-22 14:30:00', 1, 1),
('2023-09-23 10:00:00', 2, 2),
('2023-09-24 16:45:00', 3, 3),
('2023-09-25 11:30:00', 4, 4),
('2023-09-26 14:15:00', 5, 5),
('2023-09-27 08:45:00', 6, 6),
('2023-09-28 12:00:00', 7, 7),
('2023-09-29 09:30:00', 8, 8),
('2023-09-30 16:00:00', 9, 9),
('2023-10-01 10:30:00', 10, 10),
('2023-10-02 13:45:00', 11, 11),
('2023-10-03 15:00:00', 12, 12),
('2023-10-04 11:00:00', 13, 13);
INSERT INTO order_detail (order_id, product_id, note, price, quantity) VALUES
(1, 1, 'Note 1', 10.99, 2),
(1, 2, 'Note 2', 5.99, 3),
(2, 3, 'Note 3', 15.99, 1),
(3, 4, 'Note 4', 12.99, 4),
(3, 5, 'Note 5', 8.99, 2),
(4, 6, 'Note 6', 19.99, 3),
(4, 7, 'Note 7', 7.99, 1),
(5, 8, 'Note 8', 14.99, 5),
(5, 9, 'Note 9', 10.99, 2),
(6, 10, 'Note 10', 6.99, 4),
(6, 11, 'Note 11', 16.99, 2),
(7, 12, 'Note 12', 9.99, 3),
(7, 13, 'Note 13', 11.99, 1);
INSERT INTO product_image (alternative, path, product_id) VALUES
('Image 1', '/images/product1.jpg', 1),
('Image 2', '/images/product2.jpg', 2),
('Image 3', '/images/product3.jpg', 3),
('Image 4', '/images/product4.jpg', 4),
('Image 5', '/images/product5.jpg', 5),
('Image 6', '/images/product6.jpg', 6),
('Image 7', '/images/product7.jpg', 7),
('Image 8', '/images/product8.jpg', 8),
('Image 9', '/images/product9.jpg', 9),
('Image 10', '/images/product10.jpg', 10),
('Image 11', '/images/product11.jpg', 11),
('Image 12', '/images/product12.jpg', 12),
('Image 13', '/images/product13.jpg', 13);
INSERT INTO product_price (price_date_time, note, price, product_id) VALUES
('2023-09-22 12:30:45.123456', 'Initial Price', 9.99, 1),
('2023-09-21 12:30:45.123456', 'Initial Price', 14.99, 2),
('2023-09-20 14:30:00', 'Initial Price', 19.99, 3),
('2023-09-23 12:30:45.123456', 'New Price', 11.99, 4),
('2023-09-24 12:30:45.123456', 'New Price', 7.49, 5),
('2023-09-25 14:30:00', 'New Price', 22.99, 6),
('2023-09-26 12:30:45.123456', 'New Price', 6.29, 7),
('2023-09-27 14:30:00', 'New Price', 13.49, 8),
('2023-09-28 12:30:45.123456', 'New Price', 9.99, 9),
('2023-09-29 14:30:00', 'New Price', 15.79, 10),
('2023-09-30 12:30:45.123456', 'New Price', 4.99, 11),
('2023-10-01 14:30:00', 'New Price', 12.99, 12),
('2023-10-02 12:30:45.123456', 'New Price', 10.29, 13);
COMMIT;

select * from employee;
select * from customer;
select * from product;
select * from product_image;
select * from product_price;
select * from orders;
select * from order_detail;



