-- IDX의 자동 증가 시퀀스
CREATE SEQUENCE IDX_SEQ;


-- HAPPY_BOARD 테이블 생성
-- "IDX"의 값에는 IDX_SEQ.NEXTVAL 로 값을 넣어야 시퀀스값이 입력된다.
-- NICK_NAME -> FOREIGN KEY로 변경할 것
-- (ORACLE 구려ㅡ.,ㅡ;)
CREATE TABLE HAPPY_BOARD(
    IDX         NUMBER(8)    PRIMARY KEY,
    NICK_NAME   VARCHAR2(40)    NOT NULL,
    TITLE       VARCHAR2(40)    NOT NULL,
    CONTENT     VARCHAR2(500)   NOT NULL,
    REG_DATE    DATE            DEFAULT SYSDATE,
    WATCH       NUMBER(8)       DEFAULT 0,
    HIT         NUMBER(8)       DEFAULT 0,
    IMG_1       VARCHAR2(100),
    IMG_2       VARCHAR2(100),
    IMG_3       VARCHAR2(100)
);

DESC HAPPY_BOARD;

INSERT INTO HAPPY_BOARD(IDX, NICK_NAME, TITLE, CONTENT, REG_DATE)
VALUES(IDX_SEQ.NEXTVAL,
       'chocobe',
       '저 행복해요',
       '우헤헤헹',
       SYSDATE
);

SELECT * FROM HAPPY_BOARD;

DELETE FROM HAPPY_BOARD;

COMMIT;