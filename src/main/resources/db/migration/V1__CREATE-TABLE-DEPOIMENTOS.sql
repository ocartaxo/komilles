CREATE TABLE depoimentos
(
    id         SERIAL PRIMARY KEY NOT NULL,
    usuario    VARCHAR(255)       NOT NULL,
    depoimento VARCHAR(300)       NOT NULL,
    foto       VARCHAR(500)       NOT NULL
);