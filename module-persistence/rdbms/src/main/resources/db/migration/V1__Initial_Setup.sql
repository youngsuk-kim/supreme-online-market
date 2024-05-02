CREATE TABLE product_image
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    sequence    INT NOT NULL,
    created_at  TIMESTAMP(6),
    updated_at  TIMESTAMP(6),
    description VARCHAR(255),
    url         TEXT
);

CREATE TABLE product_item
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    stock       INT          NOT NULL,
    created_at  TIMESTAMP(6),
    updated_at  TIMESTAMP(6),
    product     BIGINT,
    product_id  BIGINT,
    `option`    VARCHAR(255) CHECK (`option` IN ('SIZE', 'COLOR')),
    option_name VARCHAR(255) NOT NULL,
    sku         VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE product_time_limit
(
    id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    created_at TIMESTAMP(6),
    updated_at TIMESTAMP(6),
    start_time TIMESTAMP(6),
    end_time   TIMESTAMP(6)
);

CREATE TABLE products
(
    id           BIGINT PRIMARY KEY AUTO_INCREMENT,
    amount       DECIMAL(38, 2),
    created_at   TIMESTAMP(6),
    updated_at   TIMESTAMP(6),
    brand_name   VARCHAR(255),
    description  VARCHAR(255),
    product_name VARCHAR(255)
);

CREATE TABLE users
(
    id             BIGINT PRIMARY KEY AUTO_INCREMENT,
    created_at     TIMESTAMP(6),
    updated_at     TIMESTAMP(6),
    user_secret_id BIGINT UNIQUE,
    city           VARCHAR(255),
    detail         VARCHAR(255),
    province       VARCHAR(255),
    username       VARCHAR(255) UNIQUE
);

CREATE TABLE user_secret
(
    id           BIGINT PRIMARY KEY AUTO_INCREMENT,
    created_at   TIMESTAMP(6),
    updated_at   TIMESTAMP(6),
    token        VARCHAR(500) UNIQUE,
    email        VARCHAR(255) NOT NULL UNIQUE,
    password     VARCHAR(255) NOT NULL,
    phone_number VARCHAR(255) NOT NULL UNIQUE
);
