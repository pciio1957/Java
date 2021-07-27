CREATE SEQUENCE seq_04
	INCREMENT BY 5
	START WITH 1
	MINVALUE 1
	MAXVALUE 50;
/*

#0723 정리문제의 테이블 생성하기
속성 : 학번 이름 국어 영어 수학 

*/

SELECT * FROM student;

CREATE TABLE student(
	sno NUMBER, 
	name varchar2(50),
	kor NUMBER,
	eng NUMBER, 
	math NUMBER
);

INSERT INTO student values(1000, '홍길동', 80, 80, 90);
INSERT INTO student values(1001, '김길동', 90, 80, 90);
INSERT INTO student values(1002, '신길동', 90, 90, 90);
INSERT INTO student values(1003, '오길동', 80, 70, 90);
INSERT INTO student values(1004, '마길동', 80, 85, 90);
INSERT INTO student values(1005, '하길동', 85, 80, 90);

SELECT * FROM student;


/*

#DB 처리 화면 구성
1. db 구조 만들기, 데이터 입력, sql 작성
2. vo 만들기
3. Dao, 기능메소드 구현
4. 화면에서 호출 출력 
*/