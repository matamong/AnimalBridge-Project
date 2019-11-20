create table MAP(
    email VARCHAR(30),
    x varchar(25) not null,
    y varchar(25) not null,
    map_address varchar(50) primary key,
    special varchar(50),
    title varchar(15),
    CONSTRAINT fk_map FOREIGN KEY (email)
    REFERENCES ANIMAL_MEMBER(email) ON DELETE CASCADE
);
-- ON DELETE CASCADE : 부모테이블 값이 삭제되면 연쇄적으로 자식테이블 값 역시 삭제

INSERT INTO MAP 
VALUES('a@a', '33.460001', '126.570770','어딘가','TEST','TEST');

SELECT * FROM MAP;

ALTER TABLE map DROP CONSTRAINT fk_map;
DROP TABLE map;