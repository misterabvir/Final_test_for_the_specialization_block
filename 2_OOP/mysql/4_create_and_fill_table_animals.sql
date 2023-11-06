USE HumanFriends;
DROP TABLE IF EXISTS `Animals`;

CREATE TABLE IF NOT EXISTS `Animals`(
    `animal_id` CHAR(36) PRIMARY KEY,
    `animal_name` VARCHAR(50),
    `birthday` DATE,
    `title_id` CHAR(36),
    CONSTRAINT fk_title_of_animal Foreign Key (`title_id`) REFERENCES `Titles`(`title_id`) ON DELETE CASCADE
);
INSERT INTO `Animals`(`animal_id`, `animal_name`, `birthday`, `title_id`)
VALUES 
    (UUID(), "Fido",     "2020-01-01", (SELECT title_id FROM Titles WHERE `title_name` = "Dog")),
    (UUID(), "Buddy",    "2018-12-10", (SELECT title_id FROM Titles WHERE `title_name` = "Dog")),
    (UUID(), "Bella",    "2019-11-11", (SELECT title_id FROM Titles WHERE `title_name` = "Dog")),
    (UUID(), "Whiskers", "2019-05-15", (SELECT title_id FROM Titles WHERE `title_name` = "Cat")),
    (UUID(), "Oliver",   "2020-06-30", (SELECT title_id FROM Titles WHERE `title_name` = "Cat")),
    (UUID(), "Smudge",   "2020-02-20", (SELECT title_id FROM Titles WHERE `title_name` = "Cat")),
    (UUID(), "Hammy",    "2021-03-10", (SELECT title_id FROM Titles WHERE `title_name` = "Hamster")),
    (UUID(), "Peanut",   "2021-08-01", (SELECT title_id FROM Titles WHERE `title_name` = "Hamster")),
    (UUID(), "Thunder",  "2015-07-21", (SELECT title_id FROM Titles WHERE `title_name` = "Horse")),
    (UUID(), "Storm",    "2014-05-05", (SELECT title_id FROM Titles WHERE `title_name` = "Horse")),
    (UUID(), "Blaze",    "2016-02-29", (SELECT title_id FROM Titles WHERE `title_name` = "Horse")),
    (UUID(), "Eeyore",   "2017-09-18", (SELECT title_id FROM Titles WHERE `title_name` = "Donkey")),
    (UUID(), "Burro",    "2019-01-23", (SELECT title_id FROM Titles WHERE `title_name` = "Donkey")),
    (UUID(), "Dune",     "2018-12-12", (SELECT title_id FROM Titles WHERE `title_name` = "Camel")),
    (UUID(), "Sandy",    "2016-11-03", (SELECT title_id FROM Titles WHERE `title_name` = "Camel")),
    (UUID(), "Sahara",   "2015-08-14", (SELECT title_id FROM Titles WHERE `title_name` = "Camel"));

SELECT a.animal_name, a.birthday, t.title_name
FROM `Animals` AS a
JOIN `Titles` AS t ON t.title_id = a.title_id;
