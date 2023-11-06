-- Active: 1696517013159@@127.0.0.1@3306@HumanFriends

USE `HumanFriends`;
SELECT
    a.`animal_name`,
    a.`birthday`,
    t.`title_name` AS `title_name`,
    k.`kind_name` AS `kind_name`,
    CONCAT(
        TIMESTAMPDIFF(YEAR, a.`birthday`, CURDATE()),
        ' years ',
        TIMESTAMPDIFF(MONTH, a.`birthday`, CURDATE()) % 12,
        ' months'
    ) AS `age`
FROM `Animals` as a
LEFT JOIN `Titles` AS t ON t.`title_id` = a.`title_id`
JOIN `Kinds` AS k ON t.`kind_id` = k.`kind_id`
WHERE TIMESTAMPDIFF(YEAR, a.`birthday`, CURDATE()) BETWEEN 1 AND 3;