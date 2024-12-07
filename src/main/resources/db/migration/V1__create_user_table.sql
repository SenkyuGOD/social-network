CREATE TABLE user_
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50)  NOT NULL,
    email    VARCHAR(100) NOT NULL,
    UNIQUE (username),
    UNIQUE (email)
);
