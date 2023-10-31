-- Active: 1696517013159@@127.0.0.1@3306@HumanFriends

USE `HumanFriends`;
CREATE VIEW AnimalsWithAgeFrom1To3 AS
SELECT
    a.`name`,
    a.`birthday`,
    t.title AS animal_type,
    c.title AS category,
    CONCAT(
        TIMESTAMPDIFF(YEAR, a.`birthday`, CURDATE()),
        ' years ',
        TIMESTAMPDIFF(MONTH, a.`birthday`, CURDATE()) % 12,
        ' months'
    ) AS `age`
FROM `Animals` as a
LEFT JOIN `Types` AS t ON t.id = a.type_id
JOIN `Category` AS c ON t.category_id = c.id
WHERE TIMESTAMPDIFF(YEAR, a.`birthday`, CURDATE()) BETWEEN 1 AND 3;