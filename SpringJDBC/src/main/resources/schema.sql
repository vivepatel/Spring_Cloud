DROP TABLE IF EXISTS books;

CREATE  TABLE  BOOKS(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL ,
    author VARCHAR(255) NOT NULL
);