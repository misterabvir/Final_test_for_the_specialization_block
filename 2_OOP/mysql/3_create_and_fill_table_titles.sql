-- Active: 1696517013159@@127.0.0.1@3306@HumanFriends

USE HumanFriends;

DROP TABLE IF EXISTS `Titles`;
CREATE TABLE IF NOT EXISTS `Titles`(
    `title_id`      CHAR(36) PRIMARY KEY,
    `title_name`    VARCHAR(20),
    `kind_id`       CHAR(36),
    CONSTRAINT fk_kind FOREIGN KEY(`kind_id`) REFERENCES `Kinds`(`kind_id`) ON DELETE CASCADE
);

INSERT INTO `Titles`(`title_id`, `title_name`, `kind_id`)
VALUES
    (UUID(), "Dog",     (SELECT `kind_id` FROM `Kinds` WHERE `kind_name` = "Pets")),
    (UUID(), "Cat",     (SELECT `kind_id` FROM `Kinds` WHERE `kind_name` = "Pets")),
    (UUID(), "Hamster", (SELECT `kind_id` FROM `Kinds` WHERE `kind_name` = "Pets")),
    (UUID(), "Horse",   (SELECT `kind_id` FROM `Kinds` WHERE `kind_name` = "Pack Animals")),
    (UUID(), "Camel",   (SELECT `kind_id` FROM `Kinds` WHERE `kind_name` = "Pack Animals")),
    (UUID(), "Donkey",  (SELECT `kind_id` FROM `Kinds` WHERE `kind_name` = "Pack Animals")); 

SELECT  
    t.`title_name`,
    k.`kind_name`
FROM `Titles` AS t
JOIN `Kinds` AS k ON t.`kind_id` = k.`kind_id`;
