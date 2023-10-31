USE HumanFriends;
DROP TABLE IF EXISTS `Animals`;

CREATE TABLE IF NOT EXISTS `Animals`(
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50),
    `type_id` int,
    `birthday` DATE,
    CONSTRAINT fk_type Foreign Key (`type_id`) REFERENCES `Types`(`id`)
);
INSERT INTO `Animals`(`name`, `type_id`, `birthday`)
VALUES ("Fido", 1, "2020-01-01"),
    ("Whiskers", 2, "2019-05-15"),
    ("Hammy", 3, "2021-03-10"),
    ("Buddy", 1, "2018-12-10"),
    ("Smudge", 2, "2020-02-20"),
    ("Peanut", 3, "2021-08-01"),
    ("Bella", 1, "2019-11-11"),
    ("Oliver", 2, "2020-06-30"),
    ("Thunder", 3, "2015-07-21"),
    ("Sandy", 4, "2016-11-03"),
    ("Eeyore", 5, "2017-09-18"),
    ("Storm", 6, "2014-05-05"),
    ("Dune", 4, "2018-12-12"),
    ("Burro", 5, "2019-01-23"),
    ("Blaze", 6, "2016-02-29"),
    ("Sahara", 5, "2015-08-14");
