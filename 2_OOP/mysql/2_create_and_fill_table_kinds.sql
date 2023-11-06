-- Active: 1696517013159@@127.0.0.1@3306@HumanFriends
USE HumanFriends;

DROP TABLE IF EXISTS `Kinds`;
CREATE TABLE IF NOT EXISTS `Kinds`(
    `kind_id` char(36) PRIMARY KEY,
    `kind_name` VARCHAR(50)
);

INSERT INTO `Kinds`(`kind_id`, `kind_name`)
VALUES
    (UUID(), "Pets"),
    (UUID(), "Pack Animals");

SELECT `kind_name` FROM `Kinds`;