-- ****** CREATE DATABASE ********
CREATE DATABASE IF NOT EXISTS foodDiaries 
    CHARSET utf8mb4 COLLATE utf8mb4_0900_ai_ci;

USE foodDiaries;

-- ****** CREATE TABLES ********
CREATE TABLE IF NOT EXISTS person (
    email       VARCHAR(80)                                             PRIMARY KEY NOT NULL,
    name        VARCHAR(50)                                             NOT NULL,
    surname     VARCHAR(50)                                             NOT NULL,
    password    VARCHAR(50)                                             NOT NULL,
    last_login  DATETIME                                                DEFAULT NULL,
    signup_date DATETIME                                                NOT NULL,
    role        ENUM("TRAINER", "DOCTOR", "USER", "ADMIN", "DIETICIAN") NOT NULL
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS expert (
    expert_email VARCHAR(80) NOT NULL PRIMARY KEY, 
    accepted_by  VARCHAR(80) DEFAULT NULL,
    accepted_on  DATETIME    DEFAULT NULL,
    degree       BLOB        DEFAULT NULL,

    CONSTRAINT exp_fk_per FOREIGN KEY (expert_email)
        REFERENCES person(email)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT exp_fk_per_admin FOREIGN KEY (accepted_by)
        REFERENCES person(email)
        ON UPDATE CASCADE
) ENGINE = InnoDB;


-- ****** CREATE FUNCTIONS ********


-- ****** CREATE STORED PROCEDURES ********
DELIMITER $

CREATE PROCEDURE checkNewPerson(IN email VARCHAR(80), OUT checkIfExists BOOLEAN)
BEGIN
    DECLARE check_id INT;

    SELECT id INTO check_id
    FROM person
    WHERE person.email = email;

    IF check_id IS NULL THEN
        SET checkIfExists = FALSE;
    ELSE
        SET checkIfExists = TRUE;
    END IF;

END$

DELIMITER ;


-- ****** INSERT DATA ********
INSERT INTO person VALUES ("george@gmail.com", "Γεώργιος", "Γεωργίου", "123456", "2024-05-06 15:09:45", "2023-01-15 06:00:00", "ADMIN");
INSERT INTO person VALUES ("dim@gmail.com", "Δημήτρης", "Δημητρίου", "6548225", "2024-05-06 15:09:45", "2023-01-15 06:00:00", "DOCTOR");

INSERT INTO expert VALUES ("dim@gmail.com", "george@gmail.com", "2023-01-15 06:00:00", NULL);