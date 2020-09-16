CREATE DATABASE IF NOT EXISTS task311;
use task311;
CREATE TABLE users
(
    id         BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(100)                       NOT NULL,
    last_name  VARCHAR(100)                       NOT NULL,
    email      VARCHAR(100)                       NOT NULL,
    password   VARCHAR(100)                       NOT NULL
)
    COLLATE = 'utf8_general_ci';

-- Table: roles
CREATE TABLE roles
(
    id   BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    role VARCHAR(255) NOT NULL
)
    ENGINE = InnoDB;


-- Table for mapping user and roles: user_roles
CREATE TABLE user_roles
(
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,

    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id),

    UNIQUE (user_id, role_id)
)
    ENGINE = InnoDB;


-- Insert data
INSERT INTO users
VALUES (1, 'admin', 'admin', 'admin@ya.ru', 'admin'),
       (2, 'user', 'user', 'user@ya.ru', 'user'),
       (3, 'user', 'admin', 'admin@go.com','admin');

INSERT INTO roles
VALUES (1, 'ROLE_USER');
INSERT INTO roles
VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_roles
VALUES (1, 2);
INSERT INTO user_roles
VALUES (2, 1);
INSERT INTO user_roles
VALUES (3, 1);
INSERT INTO user_roles
VALUES (3, 2);
