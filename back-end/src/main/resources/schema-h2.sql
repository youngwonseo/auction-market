CREATE TABLE `auction`.`auctions`(
    `id`                BIGINT NOT NULL AUTO_INCREMENT,
    `is_cancel`         TINYINT(1),
    `price`             BIGINT NOT NULL,
    `participants_id`   BIGINT NOT NULL,
    `products_id`       BIGINT NOT NULL,
    `created_at`        DATETIME NOT NULL,
    `updated_at`        DATETIME,
    PRIMARY KEY (`id`)
);

CREATE TABLE `auction`.`categories`(
    `id`                BIGINT NOT NULL AUTO_INCREMENT,
    `created_at`        DATETIME NOT NULL,
    `updated_at`        DATETIME,
    `title`             VARCHAR(255),
    `parent`            BIGINT,
    PRIMARY KEY (`id`)
);

CREATE TABLE `auction`.`categories_products`
(
    `categories_id`     BIGINT NOT NULL,
    `products_id`       BIGINT NOT NULL,
);

CREATE TABLE `comments`
(
    `id`                BIGINT NOT NULL AUTO_INCREMENT,
    `created_at`        DATETIME NOT NULL,
    `updated_at`        DATETIME,
    `content`           VARCHAR(255),
    `products_id`       BIGINT,
    `writer_id`         BIGINT,
    primary key (id)
);

create table files
(
    id         bigint not null auto_increment,
    filename   varchar(255),
    path       varchar(255),
    products   bigint,
    `created_at`        DATETIME NOT NULL,
    `updated_at`        DATETIME,
    primary key (id)
);

create table likes
(
    id         bigint not null auto_increment,
    `created_at`        DATETIME NOT NULL,
    products   bigint,
    users      bigint,
    PRIMARY KEY (`id`)
);

CREATE TABLE `auction`.`tagging`(
    `id`            BIGINT NOT NULL AUTO_INCREMENT,
    `product_id`   BIGINT NOT NULL,
    `tag_id`        BIGINT NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `ux_product_tag`(`product_id`, `tag_id`)
);

CREATE TABLE `auction`.`products`
(
    `id`              BIGINT NOT NULL AUTO_INCREMENT,
    content         varchar(255),
    end_date_time   datetime,
    start_date_time datetime,
    start_price     bigint,
    state           varchar(255),
    title           varchar(255),
    view_count      integer default 0,
    category_id   bigint,
    seller_id       bigint,
    `created_at`        DATETIME NOT NULL,
    `updated_at`        DATETIME,
    PRIMARY KEY (`id`)
);

CREATE TABLE `auction`.`tag`
(
    `id`              BIGINT NOT NULL AUTO_INCREMENT,
    title varchar(255),
    PRIMARY KEY (`id`)
);

CREATE TABLE `auction`.`users`
(
    `id`              BIGINT NOT NULL AUTO_INCREMENT,
    email      varchar(255),
    kakao      varchar(255),
    name       varchar(255),
    naver      varchar(255),
    role       varchar(255),
    `created_at`        DATETIME NOT NULL,
    `updated_at`        DATETIME,
    PRIMARY KEY (`id`)
);
