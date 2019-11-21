INSERT INTO animal_member(EMAIL, NAME, NICK_NAME, PASSWORD, PHONE, ADDR)
            VALUES('aa', 'aa', 'aa', 'aa', 'aa', '직원');

SELECT * FROM MEMBER;


-- MySql
create table MAP(
    member_nickname VARCHAR(30),
    x VARCHAR(25) not null,
    y VARCHAR(25) not null,
    map_address VARCHAR(50) primary key,
    special VARCHAR(50),
    title VARCHAR(50),
    FOREIGN KEY (member_nickname) REFERENCES animal_member (nick_name) 
    on delete cascade
    on update cascade
);
-- ON DELETE CASCADE : 부모테이블 값이 삭제되면 연쇄적으로 자식테이블 값 역시 삭제
-- ON UPDATE CASCADE : 부모테이블 값이 수정되면 연쇄적으로 자식테이블 값 역시 수정

INSERT INTO MAP 
VALUES('aa', '126.57170473775234', '33.45065027408781','어딘가','TEST','TEST');

SELECT * FROM MAP;
drop table map;