-- Active: 1696517013159@@127.0.0.1@3306@HumanFriends
USE HumanFriends;
DROP TABLE IF EXISTS `Commands`;

CREATE TABLE IF NOT EXISTS `Commands`(
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50),
    `animal_id` int,
    CONSTRAINT fk_animal Foreign Key (`animal_id`) REFERENCES `Animals`(`id`)
);
INSERT INTO `Commands`(`name`, `animal_id`)
VALUES 
    ("Sit", 1), ("Stay", 1), ("Fetch", 1),
    ("Sit", 2), ("Pounce", 2),
    ("Roll", 3), ("Hide", 3),
    ("Sit", 4), ("Paw", 4), ("Bark", 4),
    ("Sit", 5), ("Pounce", 5), ("Scratch", 5),
    ("Roll", 6), ("Spin", 6),
    ("Sit", 7), ("Stay", 7), ("Roll", 7),
    ("Meow", 8), ("Scratch", 8), ("Jump", 8),
    ("Trot", 9), ("Canter", 9), ("Gallop", 9),
    ("Walk", 10), ("Carry Load", 10),
    ("Walk", 11), ("Carry Load", 11), ("Bray", 11),
    ("Trot", 12), ("Canter", 12),
    ("Walk", 13), ("Sit", 13),
    ("Walk", 14), ("Bray", 14), ("Kick", 14),
    ("Trot", 15), ("Jump", 15), ("Gallop", 15),
    ("Walk", 16), ("Run", 16);

