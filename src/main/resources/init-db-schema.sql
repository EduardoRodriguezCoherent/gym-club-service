DROP SCHEMA IF EXISTS gymdb CASCADE;
CREATE SCHEMA gymdb;
USE gymdb;

CREATE TABLE IF NOT EXISTS gym_clubs (
    id               BIGINT             AUTO_INCREMENT PRIMARY KEY,
    name             VARCHAR(255)       NOT NULL,
    location         VARCHAR(255)       NOT NULL,
    discount         BIGINT             DEFAULT 0     NOT NULL,
    annual_revenue   BIGINT             DEFAULT 0
);


CREATE TABLE IF NOT EXISTS facilities (
    id                BIGINT           AUTO_INCREMENT PRIMARY KEY,
    name              VARCHAR(255)     NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS gym_club_facilities (
    gym_club_id       BIGINT NOT NULL,
    facility_id       BIGINT NOT NULL,
    PRIMARY KEY (gym_club_id, facility_id),
    FOREIGN KEY (gym_club_id) REFERENCES gym_clubs(id) ON DELETE CASCADE,
    FOREIGN KEY (facility_id) REFERENCES facilities(id) ON DELETE CASCADE
);