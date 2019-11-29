CREATE TABLE reservation (
rev_number int auto_increment PRIMARY KEY,
rev_date VARCHAR(50),
rev_time VARCHAR(50),
animal_IDX INT,
center_IDX INT,
nick_name VARCHAR(50),
phone VARCHAR(50)
);

DROP TABLE reservation;

테스트 끝난 뒤 추가할 외래키01
ALTER TABLE reservation 
ADD CONSTRAINT rev_foreing01 
FOREIGN KEY (animal_IDX)
REFERENCES animals(animal_IDX) 
ON DELETE CASCADE ON UPDATE CASCADE;

테스트 끝난 뒤 추가할 외래키02(테이블 이름 확인할것.)
ALTER TABLE reservation 
ADD CONSTRAINT rev_foreing02 
FOREIGN KEY (center_IDX)
REFERENCES center(center_IDX) 
ON DELETE CASCADE ON UPDATE CASCADE;

테스트 끝난 뒤 추가할 외래키03(참조테이블의 기본키 확인할것.)
ALTER TABLE reservation 
ADD CONSTRAINT rev_foreing03 
FOREIGN KEY (nick_name)
REFERENCES animal_member(nick_name) 
ON DELETE CASCADE ON UPDATE CASCADE;

테스트데이터
INSERT INTO reservation VALUES (
NULL, '2019-11-30', '12:00', 1, 1, 'park', '010-0000-0000');
INSERT INTO reservation VALUES (
NULL, '2019-11-31', '15:00', 2, 2, 'kim', '010-1111-1111');
