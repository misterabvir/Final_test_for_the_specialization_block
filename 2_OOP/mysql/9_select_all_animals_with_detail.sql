-- Active: 1696517013159@@127.0.0.1@3306@HumanFriends

USE `HumanFriends`;

SELECT 
    a.animal_name,
    CONCAT(
        TIMESTAMPDIFF(YEAR, a.`birthday`, CURDATE()),
        ' years ',
        TIMESTAMPDIFF(MONTH, a.`birthday`, CURDATE()) % 12,
        ' months'
    ) AS `age`,
    t.`title_name` AS `title`,
    k.`kind_name` AS `kind`,
    GROUP_CONCAT(c.command_name ORDER BY c.command_name ASC SEPARATOR ', ') AS `commands`
FROM `Animals` AS a
LEFT JOIN `Titles` AS t ON t.`title_id` = a.`title_id`
JOIN `Kinds` AS k ON k.`kind_id` = t.`kind_id`
LEFT JOIN `AnimalLearnedCommands` AS alc ON alc.`animal_id` = a.`animal_id`
JOIN `Commands` AS c ON c.`command_id` = alc.`command_id`
GROUP BY a.`animal_id`, a.`animal_name`, a.`birthday`, t.`title_name`
ORDER BY `age`;