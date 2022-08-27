--drop table books;
--drop table users;
--drop table role;

CREATE TABLE IF NOT EXISTS books
(
    id     BIGSERIAL   NOT NULL PRIMARY KEY,
    name   VARCHAR(64) NOT NULL UNIQUE,
    author VARCHAR(64),
    isbn   VARCHAR(17),
    date   date
);

CREATE TABLE IF NOT EXISTS role
(
    id     BIGSERIAL   NOT NULL PRIMARY KEY,
    role   VARCHAR(32) NOT NULL UNIQUE
);


CREATE TABLE IF NOT EXISTS users
(
    id     BIGSERIAL   NOT NULL PRIMARY KEY,
    first_name   VARCHAR(64) NOT NULL UNIQUE,
    last_name VARCHAR(64),
    role_id BIGINT NOT NULL REFERENCES role,
    password   VARCHAR (16)
);