-- orders 테이블 목데이터
INSERT INTO orders (user_id, status, created_at, updated_at)
VALUES (1, 'ORDERED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (2, 'SHIPPED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (3, 'DELIVERED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- order_item 테이블 목데이터
INSERT INTO order_item (order_id, sku, quantity, option_name, `option`, created_at, updated_at)
VALUES (1, 1001, 2, 'Size', '{"size": "10"}', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (1, 1002, 1, 'Color', '{"color": "Black"}', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (2, 1003, 1, 'Material', '{"material": "Leather"}', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (3, 1004, 2, 'Size', '{"size": "9"}', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- payments 테이블 목데이터
INSERT INTO payments (account_id, total_price, status, created_at, updated_at)
VALUES (1, 199.99, 'PENDING', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (2, 99.99, 'COMPLETED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (3, 149.99, 'REFUNDED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- shipment 테이블 목데이터
INSERT INTO shipment (order_id, shipping, created_at, updated_at)
VALUES (1, '{"address": "123 Shoe Lane", "carrier": "UPS", "delivery_date": "2024-05-05"}', CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP),
       (2, '{"address": "456 Footwear Ave", "carrier": "FedEx", "delivery_date": "2024-05-06"}', CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP),
       (3, '{"address": "789 Sneaker Blvd", "carrier": "DHL", "delivery_date": "2024-05-07"}', CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP);
