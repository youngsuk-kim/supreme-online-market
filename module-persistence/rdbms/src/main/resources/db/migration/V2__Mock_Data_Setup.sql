-- Product Image Table
INSERT INTO product_image (sequence, created_at, updated_at, description, url)
VALUES (1, '2024-01-01 12:00:00', '2024-01-01 13:00:00', 'Front view', 'http://example.com/front.jpg'),
       (2, '2024-01-02 12:00:00', '2024-01-02 13:00:00', 'Side view', 'http://example.com/side.jpg'),
       (3, '2024-01-03 12:00:00', '2024-01-03 13:00:00', 'Rear view', 'http://example.com/rear.jpg');

-- Product Item Table
INSERT INTO product_item (stock, created_at, updated_at, product, product_id, `option`, option_name, sku)
VALUES (20, '2024-01-01 12:00:00', '2024-01-01 13:00:00', 1, 1, 'SIZE', 'Medium', 'ITEM-001'),
       (30, '2024-01-02 12:00:00', '2024-01-02 13:00:00', 2, 2, 'COLOR', 'Red', 'ITEM-002');

-- Product Time Limit Table
INSERT INTO product_time_limit (created_at, updated_at, start_time, end_time)
VALUES ('2024-01-01 12:00:00', '2024-01-01 13:00:00', '2024-01-01 09:00:00', '2024-01-01 18:00:00'),
       ('2024-01-02 12:00:00', '2024-01-02 13:00:00', '2024-01-02 09:00:00', '2024-01-02 18:00:00'),
       ('2024-01-03 12:00:00', '2024-01-03 13:00:00', '2024-01-03 09:00:00', '2024-01-03 18:00:00');

-- Products Table
INSERT INTO products (amount, created_at, updated_at, brand_name, description, product_name)
VALUES (500.00, '2024-01-01 12:00:00', '2024-01-01 13:00:00', 'Brand A', 'Description A', 'Product A'),
       (1000.00, '2024-01-02 12:00:00', '2024-01-02 13:00:00', 'Brand B', 'Description B', 'Product B'),
       (1500.00, '2024-01-03 12:00:00', '2024-01-03 13:00:00', 'Brand C', 'Description C', 'Product C');

-- Users Table
INSERT INTO users (created_at, updated_at, user_secret_id, city, detail, province, username)
VALUES ('2024-01-01 12:00:00', '2024-01-01 13:00:00', 1, 'Seoul', 'Detail A', 'Seoul', 'user_a'),
       ('2024-01-02 12:00:00', '2024-01-02 13:00:00', 2, 'Busan', 'Detail B', 'Busan', 'user_b'),
       ('2024-01-03 12:00:00', '2024-01-03 13:00:00', 3, 'Incheon', 'Detail C', 'Incheon', 'user_c');

-- User Secret Table
INSERT INTO user_secret (created_at, updated_at, token, email, password, phone_number)
VALUES ('2024-01-01 12:00:00', '2024-01-01 13:00:00', 'token123', 'user_a@example.com', 'passwordA', '010-1234-5678'),
       ('2024-01-02 12:00:00', '2024-01-02 13:00:00', 'token456', 'user_b@example.com', 'passwordB', '010-2345-6789'),
       ('2024-01-03 12:00:00', '2024-01-03 13:00:00', 'token789', 'user_c@example.com', 'passwordC', '010-3456-7890');
