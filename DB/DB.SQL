DROP DATABASE IF EXISTS board;
CREATE DATABASE board;
USE board;

CREATE TABLE `User`(
 id INT(100) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
 member_id VARCHAR(50) NOT NULL,
 `password` VARCHAR(100) NOT NULL,
 password_confirm VARCHAR(100) NOT NULL,
 `name` VARCHAR(20) NOT NULL,
 nick_name VARCHAR(20) NOT NULL,
 reg_date DATETIME NOT NULL,
 update_date DATETIME NOT NULL,
 `admin` INT
);

INSERT INTO `user` SET
 member_id = "관리자",
 `password` = "1234",
 password_confirm = "1234",
 `name` = "안녕",
 nick_name = "안녕",
 reg_date = NOW() ,
 update_date = NOW(),
 `admin` = 0;

 SELECT * FROM `User`;

 CREATE TABLE Question (
    id INT(11) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    user_id INT(50) NOT NULL,
    title VARCHAR(200) NOT NULL,
    content TEXT NOT NULL,
    reg_date DATETIME NOT NULL,
    update_date DATETIME NOT NULL,
    `admin` INT
);

INSERT INTO Question SET
title = "직업 얘기하자",
content = "요즘 제일 인기 있는 직업이 뭐야?",
user_id = 1,
reg_date = NOW(),
update_date = NOW(),
`admin` = "1";

INSERT INTO Question SET
title = "맛집 추천 !",
content = "양식 맛집 추천해줘",
user_id = 1,
reg_date = NOW(),
update_date = NOW(),
`admin` = "1";

SELECT * FROM Question;

CREATE TABLE Answer (
    id INT(11) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    member_id VARCHAR(50) NOT NULL,
    content TEXT NOT NULL,
    reg_date DATETIME NOT NULL
);

SELECT * FROM Answer;