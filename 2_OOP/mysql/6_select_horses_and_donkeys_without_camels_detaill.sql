-- Active: 1696517013159@@127.0.0.1@3306@HumanFriends

USE `HumanFriends`;

CREATE VIEW PackAnimalsWithCommands AS
SELECT 
    a.id,
    a.name,
    a.birthday,
    t.title AS animal_type,
    c.title AS category,
    GROUP_CONCAT(cm.name ORDER BY cm.name ASC SEPARATOR ', ') AS concatenated_commands
FROM `Animals` AS a
LEFT JOIN `Types` AS t ON t.id = a.type_id
JOIN `Category` AS c ON t.category_id = c.id
LEFT JOIN `Commands` AS cm ON cm.animal_id = a.id
WHERE c.title = "Pack Animals" AND (t.title = "Horse" OR t.title = "Camel")
GROUP BY a.id, a.name, a.birthday, t.title, c.title;