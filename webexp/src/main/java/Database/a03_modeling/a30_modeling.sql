
CREATE TABLE entityexp01 (
	classroom varchar2(50)
);

INSERT INTO entityexp01 values('102호');

SELECT * FROM entityexp01;


-- 응용) 화면에 있는 entity와 entity type을 이용해
--		erd와 테이블 작성하기 (4조)

-- 한개의 테이블에 다 넣는줄 알고 생성 
ALTER TABLE entityexp01
ADD subject varchar2(50);

ALTER TABLE ENTITYEXP01 
ADD lecturer varchar2(30);

SELECT * FROM entityexp01;

CREATE TABLE entityexp02(
	subject varchar2(50)
);
CREATE TABLE entityexp03(
	teacher varchar2(50)
);

-- 따로 삽입
INSERT INTO entityexp02 values('J2EE');
INSERT INTO entityexp02 values('Data Modeling');

INSERT INTO entityexp03 values('이춘식');
INSERT INTO entityexp03 values('김경재');


CREATE TABLE lecture (
	classroom varchar2(50),
	subject varchar2(50),
	teacher varchar2(30)
);

DROP TABLE lecture;
-- 같이 삽입
INSERT INTO lecture values('101호', 'J2EE', '이춘식');
INSERT INTO lecture values('102호', 'Data Modeling', '김경재');


SELECT * FROM entityexp02;

SELECT * FROM entityexp03;

SELECT * FROM lecture;




-- 0715 방문실적테이블
-- 1) 방문실적 테이블 
CREATE TABLE identifiedexp01 (
	visitdate date,
	visitcode char(5),
	visitcivil char(13),
	CONSTRAINTS identifiedexp01_com_pk PRIMARY Key(visitdate, visitcode, visitcivil)
);

SELECT * FROM identifiedexp01;

-- 2) 방문실적테이블 (대리식별자)
CREATE TABLE identifiedexp02 (
	visitsid char(25) PRIMARY KEY,
	visitdate date,
	visitcode char(5),
	visitcivil char(13)
);


-- 관계란 두개의 엔티티타입 사이의 논리적인 관계
-- 즉 엔티티와 엔티티가 존재의 형태나 행위로서 서로에게 영향을 주는 형태를 말함

-- 응용2) 화면을 기준으로 erd 생성하기 (4조)
-- 1) 부서테이블
CREATE TABLE reldept(
	dname varchar2(20)
);

INSERT INTO reldept values('DB팀');

SELECT * FROM reldept;

-- 2) 사원테이블
CREATE TABLE reemp(
	ename varchar2(20),
	dname varchar2(20)
);

INSERT INTO reemp values('황경빈', 'DB팀');
INSERT INTO reemp values('김철수', 'DB팀');
INSERT INTO reemp values('홍길동', 'DB팀');

SELECT * FROM reemp;


-- 응용3) erd에서 만들 고객과 주문 엔티티의 관계에서 실제 테이블을 만들고
-- 데이터를 입력, 조회 처리하기 (4, 5조)
-- 1) 고객테이블
CREATE TABLE customer (
	cname varchar2(20) PRIMARY key
);

INSERT INTO customer values('홍길동');
INSERT INTO customer values('유길동');

SELECT * FROM customer;

-- 2) 주문테이블
CREATE TABLE cORDER (
	orderno number PRIMARY key,
	cname varchar2(20)
);

INSERT INTO cORDER values(1, '홍길동');
INSERT INTO cORDER values(2, '유길동');

SELECT * FROM customer;


-- 응용4) 화면을 기준으로 erd 생성 및 테이블 생성 후
-- 		데이터 입력, 조회 처리하기 (6조)
CREATE TABLE movie (
	title varchar2(50)
);

INSERT INTO movie values('무사');
INSERT INTO movie values('고래사냥');

SELECT * FROM movie;

create TABLE movie_actor ( 
	aname varchar2(20),
	title varchar2(50)
);

INSERT INTO movie_actor values('안성기','무사');
INSERT INTO movie_actor values('안성기','고래사냥');
INSERT INTO movie_actor values('김수철','고래사냥');


-- 응용2) 게시판 테이블
CREATE TABLE board( 
	bno number,
	bestbno number, 
	title varchar2(200),
	content varchar2(2000),
	writer varchar2(50),
	bdate date,
	cnt number
);

INSERT INTO board values(1000, 1, '제목이에요', '내용이에요', '홍길동', sysdate, 11);
INSERT INTO board values(1001, 1000, 'RE:답글작성', '내용이에요', '이길동', sysdate, 0);
INSERT INTO board values(1002, 1001, 'RE:RE:제목이에요', '내용이에요', '유길동', sysdate, 0);



CREATE TABLE starcraft (
	starno number PRIMARY key,
	parno number,
	sname varchar2(30),
	power number
);

INSERT INTO starcraft values(1, 0, '라바1', 0);
INSERT INTO starcraft values(2, 1, '저글링1', 1);

