-- Orders 테이블에 대한 목데이터
INSERT INTO orders (user_id, status) VALUES (1, 'ORDERED');
INSERT INTO orders (user_id, status) VALUES (2, 'SHIPPED');
INSERT INTO orders (user_id, status) VALUES (3, 'DELIVERED');

-- Order Item 테이블에 대한 목데이터
INSERT INTO order_item (order_id, sku, quantity, option_key, option_value)
VALUES
    (1, 1001, 2, 'SIZE', '9.5'),
    (1, 1002, 1, 'SIZE', '10'),
    (2, 1003, 1, 'COLOR', 'RED'),
    (3, 1004, 3, 'COLOR', 'RED');

-- Payments 테이블에 대한 목데이터
INSERT INTO payments (account_id, total_price, status)
VALUES
    (1, 149.99, 'PAID'),
    (2, 79.99, 'PENDING'),
    (3, 259.99, 'FAILED');

-- Shipment 테이블에 대한 목데이터
INSERT INTO shipment (order_id, sender_name, sender_phone_number, receiver_name, receiver_phone_number, city, province, detail)
VALUES
    (1, 'John Doe', '1234567890', 'Jane Doe', '0987654321', 'Seoul', 'Seoul', '123 Main St, Building A'),
    (2, 'Alice Smith', '1231231234', 'Bob Johnson', '3213214321', 'Busan', 'Busan', '456 Elm St, Building B'),
    (3, 'Charlie Brown', '5555555555', 'Lucy Van Pelt', '4444444444', 'Incheon', 'Incheon', '789 Oak St, Building C');
