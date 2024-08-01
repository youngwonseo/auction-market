CREATE TABLE `auction`.`products`
(
    `id`                BIGINT NOT NULL AUTO_INCREMENT,
    `title`             VARCHAR(255) NOT NULL,
    `content`           VARCHAR(255) NOT NULL,
    `state`             VARCHAR(255) NOT NULL,
    `start_date_time`   DATETIME NOT NULL,
    `end_date_time`     DATETIME NOT NULL,
    `start_price`       DECIMAL(10,2) NOT NULL,
    `like_count`        BIGINT DEFAULT 0,
    `view_count`        BIGINT DEFAULT 0,
    `category_id`       BIGINT NOT NULL,
    `created_by`        BIGINT NOT NULL,
    `created_at`        DATETIME NOT NULL,
    `updated_at`        DATETIME,
    `deleted_at`        DATETIME,
    PRIMARY KEY (`id`),
    KEY `ix_state` (`state`),
    KEY `ix_category_id` (`category_id`),
    KEY `ix_start_date_time_end_date_time` (`start_date_time`, `end_date_time`)
);

CREATE TABLE `auction`.`auctions`(
    `id`                BIGINT NOT NULL AUTO_INCREMENT,
    `price`             DECIMAL(10,2) NOT NULL,
    `product_id`        BIGINT NOT NULL,
    `created_by`        BIGINT NOT NULL,
    `created_at`        DATETIME NOT NULL,
    `updated_at`        DATETIME,
    `deleted_at`        DATETIME,
    PRIMARY KEY (`id`),
    KEY `ix_product_id` (`product_id`)
);

CREATE TABLE `auction`.`categories`(
    `id`                BIGINT NOT NULL AUTO_INCREMENT,
    `parent`            BIGINT,
    `title`             VARCHAR(255),
    PRIMARY KEY (`id`)
);

CREATE TABLE `auction`.`files`
(
    `id`                BIGINT NOT NULL AUTO_INCREMENT,
    `filename`          VARCHAR(255) NOT NULL,
    `path`              VARCHAR(255) NOT NULL,
    `product_id`        BIGINT NOT NULL,
    `created_at`        DATETIME NOT NULL,
    `updated_at`        DATETIME,
    PRIMARY KEY (`id`),
    KEY `ix_product_id` (`product_id`)
);

CREATE TABLE `auction`.`likes`
(
    `product_id`        BIGINT NOT NULL,
    `created_by`        BIGINT NOT NULL,
    `created_at`        DATETIME NOT NULL,
    PRIMARY KEY (`product_id`, `created_by`)
);

CREATE TABLE `auction`.`tagging`
(
    `product_id`        BIGINT NOT NULL,
    `tag_id`            BIGINT NOT NULL,
    PRIMARY KEY (`product_id`, `tag_id`)
);

CREATE TABLE `auction`.`tag`
(
    `id`                BIGINT NOT NULL AUTO_INCREMENT,
    `title`             VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `auction`.`users`
(
    `id`                BIGINT NOT NULL AUTO_INCREMENT,
    `email`             VARCHAR(255) NOT NULL,
    `name`              VARCHAR(255) NOT NULL,
    `kakao_id`          VARCHAR(255),
    `naver_id`          VARCHAR(255),
    `role`              VARCHAR(255),
    `created_at`        DATETIME NOT NULL,
    `updated_at`        DATETIME,
    PRIMARY KEY (`id`),
    UNIQUE `ux_email`(`email`)
);
