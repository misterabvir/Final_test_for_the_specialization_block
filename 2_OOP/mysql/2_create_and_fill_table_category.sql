-- Active: 1696517013159@@127.0.0.1@3306@HumanFriends
USE HumanFriends;

DROP TABLE IF EXISTS `Category`;
CREATE TABLE IF NOT EXISTS `Category`(
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `title` VARCHAR(20)
);

INSERT INTO `Category`(`title`)
VALUES
    ("Pets"),
    ("Pack Animals");