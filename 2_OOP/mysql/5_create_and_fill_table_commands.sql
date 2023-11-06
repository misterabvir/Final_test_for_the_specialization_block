-- Active: 1696517013159@@127.0.0.1@3306@HumanFriends
USE HumanFriends;
DROP TABLE IF EXISTS `Commands`;

CREATE TABLE IF NOT EXISTS `Commands`(
    `command_id` CHAR(36) PRIMARY KEY,
    `command_name` VARCHAR(50),
    `title_id` CHAR(36),
    CONSTRAINT fk_available_command Foreign Key (`title_id`) REFERENCES `Titles`(`title_id`) ON DELETE CASCADE
);
INSERT INTO `Commands`(`command_id`, `command_name`, `title_id`)
VALUES 
    (UUID(), "Sit",        (SELECT `title_id` FROM Titles WHERE `title_name` = "Dog")),
    (UUID(), "Stay",       (SELECT `title_id` FROM Titles WHERE `title_name` = "Dog")),
    (UUID(), "Fetch",      (SELECT `title_id` FROM Titles WHERE `title_name` = "Dog")),
    (UUID(), "Paw",        (SELECT `title_id` FROM Titles WHERE `title_name` = "Dog")),
    (UUID(), "Bark",       (SELECT `title_id` FROM Titles WHERE `title_name` = "Dog")),
    (UUID(), "Roll",       (SELECT `title_id` FROM Titles WHERE `title_name` = "Dog")),
    (UUID(), "Sit",        (SELECT `title_id` FROM Titles WHERE `title_name` = "Cat")),
    (UUID(), "Pounce",     (SELECT `title_id` FROM Titles WHERE `title_name` = "Cat")),
    (UUID(), "Scratch",    (SELECT `title_id` FROM Titles WHERE `title_name` = "Cat")),
    (UUID(), "Meow",       (SELECT `title_id` FROM Titles WHERE `title_name` = "Cat")),
    (UUID(), "Jump",       (SELECT `title_id` FROM Titles WHERE `title_name` = "Cat")),
    (UUID(), "Hide",       (SELECT `title_id` FROM Titles WHERE `title_name` = "Hamster")),
    (UUID(), "Spin",       (SELECT `title_id` FROM Titles WHERE `title_name` = "Hamster")),
    (UUID(), "Roll",       (SELECT `title_id` FROM Titles WHERE `title_name` = "Hamster")),
    (UUID(), "Trot",       (SELECT `title_id` FROM Titles WHERE `title_name` = "Horse")),
    (UUID(), "Canter",     (SELECT `title_id` FROM Titles WHERE `title_name` = "Horse")),
    (UUID(), "Gallop",     (SELECT `title_id` FROM Titles WHERE `title_name` = "Horse")),
    (UUID(), "Jump",       (SELECT `title_id` FROM Titles WHERE `title_name` = "Horse")),
    (UUID(), "Walk",       (SELECT `title_id` FROM Titles WHERE `title_name` = "Camel")),
    (UUID(), "Carry Load", (SELECT `title_id` FROM Titles WHERE `title_name` = "Camel")),
    (UUID(), "Sit",        (SELECT `title_id` FROM Titles WHERE `title_name` = "Camel")),
    (UUID(), "Run",        (SELECT `title_id` FROM Titles WHERE `title_name` = "Camel")),
    (UUID(), "Walk",       (SELECT `title_id` FROM Titles WHERE `title_name` = "Donkey")),
    (UUID(), "Carry Load", (SELECT `title_id` FROM Titles WHERE `title_name` = "Donkey")),
    (UUID(), "Bray",       (SELECT `title_id` FROM Titles WHERE `title_name` = "Donkey")),
    (UUID(), "Kick",       (SELECT `title_id` FROM Titles WHERE `title_name` = "Donkey"));

SELECT c.`command_name`, t.`title_name`
FROM `Commands` AS c
JOIN `Titles` AS t ON t.`title_id` = c.`title_id`;



