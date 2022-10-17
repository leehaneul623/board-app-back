DROP DATABASE IF EXISTS board;
CREATE DATABASE board;
USE board;

CREATE TABLE `User`(
 id INT(100) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
 member_id VARCHAR(50) NOT NULL,
 `password` VARCHAR(100) NOT NULL,
 `name` VARCHAR(20) NOT NULL,
 nickname VARCHAR(20) NOT NULL,
 reg_date DATETIME NOT NULL,
 update_date DATETIME NOT NULL
);

INSERT INTO `user` SET
 member_id = "관리자",
 `password` = "1234",
 `name` = "안녕",
 nickname = "안녕",
 reg_date = NOW() ,
 update_date = NOW();

 SELECT * FROM `User`;

 CREATE TABLE Question (
    id INT(11) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    user_id INT(50) NOT NULL,
    title VARCHAR(200) NOT NULL,
    content TEXT NOT NULL,
    reg_date DATETIME NOT NULL,
    update_date DATETIME NOT NULL
);

INSERT INTO Question SET
title = "직업 얘기하자",
content = "요즘 제일 인기 있는 직업이 뭐야?",
user_id = 1,
reg_date = NOW(),
update_date = NOW();

INSERT INTO Question SET
title = "맛집 추천 !",
content = "양식 맛집 추천해줘",
user_id = 1,
reg_date = NOW(),
update_date = NOW();

SELECT * FROM Question;

CREATE TABLE Answer (
    id INT(11) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    member_id VARCHAR(50) NOT NULL,
    content TEXT NOT NULL,
    reg_date DATETIME NOT NULL
);

SELECT * FROM Answer;