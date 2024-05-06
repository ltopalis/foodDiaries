-- ****** CREATE DATABASE ********
CREATE DATABASE IF NOT EXISTS foodDiaries;

USE foodDiaries;

-- ****** CREATE TABLES ********
CREATE TABLE IF NOT EXISTS person (
    id          INT                                                     PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name        VARCHAR(50)                                             NOT NULL,
    surname     VARCHAR(50)                                             NOT NULL,
    email       VARCHAR(80)                                             NOT NULL,
    password    VARCHAR(50)                                             NOT NULL,
    last_login  DATETIME                                                DEFAULT NULL,
    signup_date DATETIME                                                NOT NULL,
    role        ENUM("TRAINER", "DOCTOR", "USER", "ADMIN", "DIETICIAN") NOT NULL
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS expert (
    expert_id   INT      NOT NULL PRIMARY KEY, 
    accepted_by INT      DEFAULT NULL,
    accepted_on DATETIME DEFAULT NULL,
    degree      BLOB     DEFAULT NULL,

    CONSTRAINT exp_fk_per FOREIGN KEY (expert_id)
        REFERENCES person(id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT exp_fk_per_admin FOREIGN KEY (accepted_by)
        REFERENCES person(id)
        ON UPDATE CASCADE
) ENGINE = InnoDB;

-- ****** CREATE STORED PROCEDURES ********
DELIMITER $
CREATE PROCEDURE checkNewPerson(IN email VARCHAR(80), OUT checkIfExists BOOLEAN)
BEGIN
    DECLARE check INT;

    SELECT id INTO check
    FROM person
    WHERE person.email = email;

    IF check IS NULL
    THEN
        checkIfExists = FALSE;
    ELSE
        checkIfExists = TRUE;
    END IF;

END$


DELIMITER ;

-- ****** INSERT DATA ********
INSERT INTO person VALUES (NULL, "Γεώργιος", "Γεωργίου", "george@gmail.com", "123456", "2024-05-06 15:09:45", "2023-01-15 06:00:00", "ADMIN");
INSERT INTO person VALUES (NULL, "Δημήτρης", "Δημητρίου", "dim@gmail.com", "6548225", "2024-05-06 15:09:45", "2023-01-15 06:00:00", "DOCTOR");

INSERT INTO expert VALUES (2, 1, "2023-01-15 06:00:00", NULL);