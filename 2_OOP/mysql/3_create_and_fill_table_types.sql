-- Active: 1696517013159@@127.0.0.1@3306@HumanFriends

USE HumanFriends;

DROP TABLE IF EXISTS `Types`;
CREATE TABLE IF NOT EXISTS `Types`(
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `title` VARCHAR(20),
    `category_id` INT,
    CONSTRAINT fk_category FOREIGN KEY(`category_id`) REFERENCES `Category`(`id`)
);

INSERT INTO `Types`(`title`, `category_id`)
VALUES
    ("Dog", 1),
    ("Cat", 1),
    ("Hamster", 1),
    ("Horse", 2),
    ("Camel", 2),
    ("Donkey", 2); 
    