CREATE TABLE IF NOT EXISTS books_1
(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name VARCHAR (64) NOT NULL UNIQUE ,
    author VARCHAR (64),
    isbn VARCHAR (17)
)

INSERT INTO books (author, isbn, name)
VALUES ('Lev Tolstoy', null, 'war and peace'),
       ('James Joyce', null, 'ULYSSES'),
       ('George Orwell', null, '1984'),
       ('Vladimir Nabokov', null, 'LOLITA'),
       ('William Shakespeare ', null, 'Hamlet'),
       ('dfsdfsda', null, 'sefwef'),
       ('sdfasdfasdf', null, 'fsdfsadf'),
       ('Turgenev', null, 'mu mu'),
       ('Bram Stoker', null, 'Dracula'),
       ('Leo Tolstoy', null, 'Anna Karenina'),
       ('Leo Tolstoy-2', null, 'Anna Karenin-2'),
       ('Leo Tolstoy-4', null, 'Anna Karenin-4'),
       ('Leo Tolstoy-5', null, 'Anna Karenin-5'),
       ('Leo Tolstoy-6', null, 'Anna Karenin-6'),
       ('Leo Tolstoy-13', null, 'Anna Karenin-3'),
       ('Michail Lermontov', null, 'maskarad'),
       ('A. Pushkin', null, 'Stihi');