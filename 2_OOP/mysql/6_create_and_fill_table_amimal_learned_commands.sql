-- Active: 1696517013159@@127.0.0.1@3306@HumanFriends


-- creating table
USE HumanFriends;

DROP TABLE IF EXISTS `AnimalLearnedCommands`;

CREATE TABLE IF NOT EXISTS `AnimalLearnedCommands` (
    `command_id` CHAR(36),
    `animal_id` CHAR(36),
    PRIMARY KEY (`command_id`, `animal_id`),
    CONSTRAINT `fk_learned_command` FOREIGN KEY (`command_id`) REFERENCES `Commands` (`command_id`) ON DELETE CASCADE,
    CONSTRAINT `fk_trained_animal` FOREIGN KEY (`animal_id`) REFERENCES `Animals` (`animal_id`) ON DELETE CASCADE
);

-- procedure for fill table
DELIMITER //
CREATE PROCEDURE AnimalTraining(
    IN animalTitle VARCHAR(255),
    IN commandName VARCHAR(255),
    IN animalName VARCHAR(255)
)
BEGIN
    DECLARE animalId CHAR(36);
    DECLARE commandId CHAR(36);

    -- Find the animal_id based on the animalName
    SELECT `animal_id` INTO animalId FROM `Animals` WHERE `animal_name` = animalName;

    -- Find the command_id based on the commandName and animalTitle
    SELECT c.`command_id` INTO commandId
    FROM `Commands` c 
    JOIN `Titles` t ON c.title_id = t.title_id
    WHERE c.`command_name` = commandName AND t.`title_name` = animalTitle;

    -- Insert the learned command into the AnimalLearnedCommands table
    INSERT INTO `AnimalLearnedCommands` (`command_id`, `animal_id`)
    VALUES (commandId, animalId);
END //
DELIMITER ;

-- training
CALL `AnimalTraining`("Dog", "Sit", "Fido");
CALL `AnimalTraining`("Dog", "Stay", "Fido");
CALL `AnimalTraining`("Dog", "Fetch", "Fido");

CALL `AnimalTraining`("Dog", "Sit", "Buddy");
CALL `AnimalTraining`("Dog", "Paw", "Buddy");
CALL `AnimalTraining`("Dog", "Bark", "Buddy");

CALL `AnimalTraining`("Dog", "Sit", "Bella");
CALL `AnimalTraining`("Dog", "Stay", "Bella");
CALL `AnimalTraining`("Dog", "Roll", "Bella");

CALL `AnimalTraining`("Cat", "Sit", "Whiskers");
CALL `AnimalTraining`("Cat", "Pounce", "Whiskers");

CALL `AnimalTraining`("Cat", "Sit", "Smudge");
CALL `AnimalTraining`("Cat", "Pounce", "Smudge");
CALL `AnimalTraining`("Cat", "Scratch", "Smudge");

CALL `AnimalTraining`("Cat", "Meow", "Oliver");
CALL `AnimalTraining`("Cat", "Scratch", "Oliver");
CALL `AnimalTraining`("Cat", "Jump", "Oliver");

CALL `AnimalTraining`("Hamster", "Roll", "Hammy");
CALL `AnimalTraining`("Hamster", "Hide", "Hammy");

CALL `AnimalTraining`("Hamster", "Roll", "Peanut");
CALL `AnimalTraining`("Hamster", "Spin", "Peanut");

CALL `AnimalTraining`("Horse", "Trot", "Thunder");
CALL `AnimalTraining`("Horse", "Canter", "Thunder");
CALL `AnimalTraining`("Horse", "Gallop", "Thunder");

CALL `AnimalTraining`("Horse", "Trot", "Storm");
CALL `AnimalTraining`("Horse", "Canter", "Storm");

CALL `AnimalTraining`("Horse", "Trot", "Blaze");
CALL `AnimalTraining`("Horse", "Jump", "Blaze");
CALL `AnimalTraining`("Horse", "Gallop", "Blaze");

CALL `AnimalTraining`("Camel", "Walk", "Sandy");
CALL `AnimalTraining`("Camel", "Carry Load", "Sandy");

CALL `AnimalTraining`("Camel", "Walk", "Dune");
CALL `AnimalTraining`("Camel", "Sit", "Dune");

CALL `AnimalTraining`("Camel", "Walk", "Sahara");
CALL `AnimalTraining`("Camel", "Run", "Sahara");

CALL `AnimalTraining`("Donkey", "Walk", "Eeyore");
CALL `AnimalTraining`("Donkey", "Carry Load", "Eeyore");
CALL `AnimalTraining`("Donkey", "Bray", "Eeyore");

CALL `AnimalTraining`("Donkey", "Walk", "Burro");
CALL `AnimalTraining`("Donkey", "Bray", "Burro");
CALL `AnimalTraining`("Donkey", "Kick", "Burro");

-- check result
SELECT a.`animal_name`, GROUP_CONCAT(c.`command_name` ORDER BY c.`command_name`) AS `learned_commands`
FROM `AnimalLearnedCommands` as ac
JOIN `Commands` c ON c.`command_id` = ac.`command_id`
JOIN `Animals` a ON a.`animal_id` = ac.`animal_id`
GROUP BY a.`animal_name`;

