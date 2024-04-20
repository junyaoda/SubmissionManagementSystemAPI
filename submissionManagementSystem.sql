
CREATE TABLE group_name (
    id INT PRIMARY KEY auto_increment,  
    group_name VARCHAR(50) NOT NULL
);
INSERT INTO SubmissionManagementSystem.`group_name`
(group_name)
VALUES
( '福岡技術部'),
( '東京本社'),
( 'R6.新卒')
;


CREATE TABLE user (
    id int PRIMARY KEY auto_increment,
    slack_id VARCHAR(11) NOT NULL,
    user_name VARCHAR(50) NOT NULL
);
INSERT INTO SubmissionManagementSystem.`user`
(slack_id, user_name)
VALUES

( '12345678901', 'テスト　太郎'),
( '12345678902', 'テスト　次郎'),
( 'U06BG6N7P3K', 'テスト　三郎')
;

CREATE TABLE group_member (
    group_id int NOT NULL,
    user_id int NOT NULL,
  FOREIGN KEY (`group_id`) REFERENCES `Group_Name` (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `User` (`id`)
);
INSERT INTO SubmissionManagementSystem.`group_member`
(group_id, user_id)
VALUES
( 1, 1),
( 1, 2),
( 1, 3),
( 2, 1),
( 2, 2),
( 3, 3)
;

CREATE TABLE submission (
    id INT PRIMARY KEY auto_increment,
    user_id int,
    content VARCHAR(50),
    url VARCHAR(50),
    comment VARCHAR(50),
    deadline date,
    remind_date_time date,
    complete_flag boolean,
    FOREIGN KEY (`user_id`) REFERENCES `User` (`id`)
);
INSERT INTO SubmissionManagementSystem.submission
(user_id, content, url, comment, deadline, remind_date_time, complete_flag)
VALUES
(1, 'レジュメ作成', 'aaa.html','テスト太郎', '2024/01/31', '2024/01/20',0),
(2, '目標シート作成', 'bbb.html','テスト次郎', '2024/05/31', '2024/01/20',0),
(3, '経費申請', 'ccc.html','テスト三郎', '2024/07/31', '2024/01/20',0);

