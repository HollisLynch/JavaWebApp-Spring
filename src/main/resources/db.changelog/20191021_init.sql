CREATE SEQUENCE hibernate_sequence;

CREATE TABLE profile
(
    id       BIGSERIAL,
    name     VARCHAR(30),
    fullName VARCHAR(50),
    email    VARCHAR(30),
    birth    VARCHAR(17),
    password VARCHAR,
    role VARCHAR,

    PRIMARY KEY (id)
);
