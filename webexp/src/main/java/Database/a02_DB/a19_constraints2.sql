
/*

#check
1. 특정한 데이터를 조건이나 범위를 지정해서 해당 범위에 데이터만 입력되도록 처리하는 것을 말한다.
2. 형식
	제약조건명 지정 : 컬럼명 데이터유형 constraints 제약명 check (조건문-where문에 들어가는 sql문장)
	제약조건명 지정x : 컬럼명 데이터유형 check (조건문-where문에 들어가는 sql문장)

*/

CREATE TABLE student05(
	gender varchar2(1) CHECK(gender IN ('F', 'M'))
);

INSERT INTO student05 values('F');
INSERT INTO student05 values('M');
INSERT INTO student05 values('K');
INSERT INTO student05 values(null);
INSERT INTO student05 values('null');

SELECT * FROM student05;


-- 응용) student07 테이블을 만들고 이름, 학년(제약조건 : 1~4학년), 
-- 국어(제약조건 : 1~100)로 데이터입력 후 출력하기  (6조)
	

CREATE TABLE student07(
	name varchar2(30) ,
	grade NUMBER CONSTRAINTS student07_grade_ck check(grade IN (1, 2, 3, 4)),
	kor NUMBER CHECK(kor BETWEEN 1 AND 100)
);

DROP TABLE student07;

-- 데이터유형은 '' 문자열입력시, 25 숫자입력시 사용
INSERT INTO student07 values('홍길동', 1, 100);
INSERT INTO student07 values('오길동', 2, 0); -- 국어점수범위 벗어남
INSERT INTO student07 values('김길동', 7, 50); -- 학년범위 벗어남
INSERT INTO student07 values('이길동', 3, -50); -- 국어점수범위 벗어남
INSERT INTO student07 values('김길동', 4, null); -- NULL 가능
INSERT INTO student07 values('김길동', null, null); -- null가능

SELECT * FROM student07;


/*
#외래키 설정관계(foreign key)
1. 연관관계에 있는 두 테이블에 대해 한쪽 테이블에 있는 데이터 기준으로
	다른쪽 테이블의 데이터를 입력할 수 있게 하는 것을 말한다.
	
2. 기본 형식
	컬럼명 데이터유형 constraints 테이블명_컬럼명_fk references 테이블명(컬럼명)
	

*/

-- 교수테이블 생성 
CREATE TABLE teacher01 (
	tno NUMBER PRIMARY key
);

INSERT INTO teacher01 values(10);
INSERT INTO teacher01 values(11);
INSERT INTO teacher01 values(12);

SELECT * FROM teacher01;

CREATE TABLE student08 (
	name varchar2(50),
	tno NUMBER CONSTRAINT student08_tno_fk REFERENCES teacher01(tno)
);

INSERT INTO student08 values('홍길동', 10);
INSERT INTO student08 values('옹길동', 11);
INSERT INTO student08 values('오길동', 12);
INSERT INTO student08 values('우길동', 13); -- 외래키의 범위에서 벗어남

SELECT * FROM student08;


-- 응용) 물건테이블(물건번호, 물건명, 가격, 재고량)
--		구매테이블(구매번호, 구매수량, 물건번호-외래키) (1조)
-- 		문제의 재고량과 구매수량은 컬럼명을 구분해서 설정하는것이 좋다!! 
--		나도 cnt로 해서 바꿔줘야함

CREATE TABLE product02 (
	pno NUMBER PRIMARY key,
	pname varchar2(50),
	price NUMBER,
	rcnt NUMBER -- 재고
);

DROP TABLE product02;

INSERT INTO product02 values(1, '컵', 1000, 2);
INSERT INTO product02 values(2, '거울', 3000, 1);
INSERT INTO product02 values(3, '연필', 500, 4);

CREATE TABLE buy02 (
	bno NUMBER CONSTRAINT buy02_bno_pk PRIMARY key,
	bcnt NUMBER, -- 수매수량
	pno NUMBER CONSTRAINT buy02_pno_fk REFERENCES product02(pno)
);

INSERT INTO buy02 values(1, 2, 1);
INSERT INTO buy02 values(2, 5, 5); -- fk의 범위벗어남
INSERT INTO buy02 values(3, 1, 2);
INSERT INTO buy02 values(4, 1, 2);

SELECT * FROM buy02;
SELECT * FROM product02;

SELECT pname, price "판매가격", bcnt "구매갯수", price*bcnt "총계", cnt-bcnt "현재재고량"
FROM product02 p, buy02 b 
WHERE p.pno = b.pno;