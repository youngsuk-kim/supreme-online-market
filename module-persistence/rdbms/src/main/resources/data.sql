
INSERT INTO time_limit(start_time, end_time) VALUES (now(), now());
INSERT INTO product(name, brand_name, description, amount, type, time_limit_id)
VALUES ('Supreme x MM6 Maison Margiela Box Logo T-Shirt White - 24SS', '마르지엘라', '슈프림 x MM6 메종 마르지엘라 박스 로고 티셔츠 화이트 - 24SS', 100000, 'LIMIT', 1);
INSERT INTO product_option_item(product_id, option, name, stock) VALUES (1, 'SIZE', 'LARGE', 20);
INSERT INTO product_option_item(product_id, option, name, stock) VALUES (1, 'SIZE', 'FREE', 20);


