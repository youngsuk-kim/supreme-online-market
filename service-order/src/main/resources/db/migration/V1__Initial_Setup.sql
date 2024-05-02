CREATE TABLE orders
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id    BIGINT      NOT NULL,
    status     VARCHAR(20) NOT NULL DEFAULT 'ORDERED',
    created_at TIMESTAMP            DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP            DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE order_item
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_id     BIGINT       NOT NULL,
    sku          BIGINT       NOT NULL,
    quantity     BIGINT       NOT NULL,
    option_key   VARCHAR(255) NOT NULL,
    option_value VARCHAR(50)  NOT NULL,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (order_id) REFERENCES orders (id)
);

CREATE TABLE payments
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    account_id  BIGINT         NOT NULL,
    total_price DECIMAL(19, 4) NOT NULL,
    status      VARCHAR(20)    NOT NULL,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE shipment
(
    id                    BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_id              BIGINT       NOT NULL,
    sender_name           VARCHAR(255) NOT NULL,
    sender_phone_number   VARCHAR(20)  NOT NULL,
    receiver_name         VARCHAR(255) NOT NULL,
    receiver_phone_number VARCHAR(20)  NOT NULL,
    city                  VARCHAR(100) NOT NULL,
    province              VARCHAR(100) NOT NULL,
    detail                VARCHAR(255) NOT NULL,
    created_at            TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at            TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
