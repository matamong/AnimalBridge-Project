-- root계정의 로그인 방식 변경 (외부에서 root계정 접속 문제 해결)
ALTER USER root@localhost IDENTIFIED WITH mysql_native_password BY '1111';

CREATE TABLE ANIMAL_MEMBER(
    EMAIL           VARCHAR(30) PRIMARY KEY,
    NAME            VARCHAR(10) NOT NULL,
    NICK_NAME       VARCHAR(20) UNIQUE NOT NULL,
    PASSWORD        VARCHAR(20) NOT NULL,
    PHONE           VARCHAR(11) UNIQUE NOT NULL,
    ADDR            VARCHAR(30) NOT NULL,
    EDU_STATE       VARCHAR(5)  DEFAULT 'NO',
    NO_SHOW_CNT     INT		     DEFAULT 0,
    GRADE           VARCHAR(20)
);

DROP TABLE ANIMAL_MEMBER;

INSERT INTO ANIMAL_MEMBER (EMAIL, NAME, NICK_NAME, PASSWORD, PHONE, ADDR)
            VALUES('a@a', 'kim', 'chocobe', 'pw', '010', '부산');
            
SELECT * FROM ANIMAL_MEMBER;



