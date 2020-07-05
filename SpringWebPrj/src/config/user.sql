USE spring_test;

CREATE TABLE IF NOT EXISTS USERS(
	userid VARCHAR(30) NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    gender VARCHAR(10),
    city VARCHAR(30)
);

INSERT INTO USERS VALUES('gildong', '홍길동', '남', '서울');
INSERT INTO USERS VALUES('younghwi', '김영희', '여', '광주');

COMMIT;