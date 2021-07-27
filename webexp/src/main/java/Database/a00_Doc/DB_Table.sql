
-- 피자헛 메뉴DB
CREATE TABLE MENU (
	mkind varchar2(30),
	mname varchar2(50),
	mprice NUMBER,
	msize varchar2(30)
);


-- DB 데이터 추가
INSERT INTO MENU VALUES('피자', '수퍼슈프림', 19900, 'L');
INSERT INTO MENU VALUES('피자', '치즈', 14900, 'M');
INSERT INTO MENU VALUES('피자', '페퍼로니', 16900, 'L');
INSERT INTO MENU VALUES('피자', '직화불고기', 19900, 'L');

INSERT INTO MENU VALUES('음료', '펩시', 2000, '1.25L');
INSERT INTO MENU VALUES('음료', '펩시', 1400, '0.5L');

SELECT * FROM MENU;


CREATE TABLE ecoupon(
	coupon varchar2(10),
	usedate	DATE		
);

CREATE TABLE ecoupon(
	coupon varchar2(30),
	useday VARCHAR2(30)   
);


INSERT INTO ecoupon VALUES('BR-1987-876-432', '1990-01-01');
INSERT INTO ecoupon VALUES('ad-4567-789-123','1990-01-06');


COMMENT ON TABLE ecoupon IS '피자헛 Ecoupon';

COMMENT ON COLUMN ecoupon.coupon IS '쿠폰번호';
COMMENT ON COLUMN ecoupon.useday IS '사용기한';
CREATE INDEX ecoupon_idx01 ON ecoupon(coupon, useday);



CREATE TABLE cart (
	ckind varchar2(30),
	cname varchar2(50),
	cprice NUMBER,
	csize varchar2(50),
	ccnt NUMBER
);

-- 위의 카트 디비에 추가한 내용
CREATE TABLE cart2 (
	cevent varchar2(50),
	cReceive carchar2(30),
	ckind varchar2(30),
	cname varchar2(50),
	cprice NUMBER,
	csize varchar2(50),
	ccnt NUMBER
);

INSERT INTO cart values('피자', '고구마피자', 8000, 'L', 2);
INSERT INTO cart values('음료', '콜라', 1000, '500ml', 3);


SELECT * FROM cart;


-- 아직 실행안함
CREATE TABLE SetMenu (
	sevent varchar2(50), -- 세트명(이벤트배너에서 보이는)
	skind varchar2(30), -- 세트구분 - 피자인지/사이드인지.. 
	sname varchar2(50), -- 세트에 포함되는 메뉴명
	sreceive varchar2(30), -- 배달인지 포장인지
	sprice NUMBER, -- 세트메뉴의 가격 
	ssize varchar2(30) -- 세트메뉴 사이즈
);



INSERT INTO SetMenu values('피치맥세트', '피자', '페퍼로니피자', '포장', 22900, 'L');
INSERT INTO SetMenu values('피치맥세트', '사이드', '순살허브치킨', '포장', 22900, '8조각');
INSERT INTO SetMenu values('피치맥세트', '음료', '제주맥주 2캔', '포장', 22900, '355ml');

INSERT INTO SetMenu values('피치콜세트', '피자', '불고기피자', '배달', 22900, 'L');
INSERT INTO SetMenu values('피치콜세트', '사이드', '순살허브치킨', '배달', 22900, '8조각');
INSERT INTO SetMenu values('피치콜세트', '음료', '펩시', '배달', 22900, '1.25L');

SELECT * FROM setmenu;



CREATE TABLE Store (
	name varchar2(50), 
	address varchar2(100),
	hp varchar2(30),
	ticket varchar2(100)
);

INSERT INTO Store values('강남상회', '서울 강남구 봉은사로 179 H타워 지층 1호 CU 편의점', '02-3448-3500' , '로또6/45');
INSERT INTO Store values('로또복권방서울', '서울 강남구 강남대로122길 50 상명빌딩 103호', '02-3444-7240', '로또6/45');
INSERT INTO Store values('프로토 포이점서울', '서울 강남구 논현로 36 태양빌딩103호', '02-578-9377	' ,'로또6/45');
INSERT INTO Store values('CU역삼점서울', '서울 강남구 테헤란로51길 10 1층', '02-539-0456', '현금복권,스피또');
INSERT INTO Store values('신사우리가판서울', '서울 강남구 강남대로 620-2 강남신사현대우편취급소 앞', '02-516-7234', '로또6/45,현금복권,스피또');


INSERT INTO Store values('로또복권판매점', '경기 여주시 세종로 59', '031-885-3337', '로또6/45');
INSERT INTO Store values('복권나라', '강원 춘천시 퇴계로145번길 11-15 1층', '033-257-0153', '로또6/45');
INSERT INTO Store values('돌하르방복권', '제주 서귀포시 태평로353번길 9 나눔로또', '064-762-5735', '로또6/45,현금복권,스피또');

SELECT * FROM store;



-- 판매점조회의 단어검색
SELECT name "상호명", address "소재지", 
	hp "전화번호", ticket "취급복권"
FROM store
WHERE name LIKE '%' || word || '%'
OR address LIKE '%' || word || '%';

-- 판매점조회의 지역검색
SELECT substr(address, 1, instr(address, ' ')) "시/도", 
	substr(address, instr(address, ' '), 
	instr(address, ' ', 1, 2)-instr(address, ' ')) "구/군"
FROM store
WHERE address LIKE '%' || word || '%';





-- 당첨번호를 배열로 넣으려고 했는데 안됨.. 데이터형이 배열이 없어서 새로운 테이블을 이용해서 각각 삽입하고 자바에서 배열에 삽입해서 쓰는 식으로 해야할듯

CREATE TABLE WinStore(
	taxis NUMBER,
	grade NUMBER,
	drawmethod varchar2(30),
	name varchar2(50), 
	address varchar2(100)
);

SELECT * FROM winstore;

INSERT INTO winstore values(967, 1, '자동', '강남상회', '서울 강남구 봉은사로 179 H타워');
INSERT INTO winstore values(967, 2, '수동', '로또복권판매점', '경기 여주시 세종로 59');
INSERT INTO winstore values(967, 2, '수동', '복권나라', '강원 춘천시 퇴계로145번길 11-15 1층');
INSERT INTO winstore values(966, 2, '수동', '신사우리가판', '서울 강남구 강남대로 620-2 강남신사현대우편취급소 앞');
INSERT INTO winstore values(966, 1, '수동', 'CU역삼점', '서울 강남구 테헤란로51길 10 1층');


-- 당첨판매점의 회차검색 (word = 967)
/*SELECT taxis "회차", grade "당첨등수", 
	drawmethod "구분", name "상호명", address "소재지"
FROM winstore
WHERE taxis = word;
*/

-- 당첨판매점의 단어검색 (word = 복권)
/*
SELECT taxis "회차", grade "당첨등수", 
	drawmethod "구분", name "상호명", address "소재지"
FROM winstore 
WHERE name LIKE '%' || word || '%' 
OR address LIKE '%' || word || '%';
*/



-- 5차 플젝 
-- userId 줄인건데 UID가 이미ㅣ 있어서 0 추가

-- USER 테이블 생성 SQL문
CREATE TABLE JSMUSER (
	UID0 varchar2(30) CONSTRAINTS JSMUSER_UID_PK PRIMARY KEY,
	UPW varchar2(30) CONSTRAINTS JSMUSER_UPW_NN NOT NULL,
	UEMAIL varchar2(100) CONSTRAINT JSMUSER_UMAIL_UQ UNIQUE,
	UB_YR number CONSTRAINT JSMUSER_UB_YR_CK CHECK(UB_YR BETWEEN 1900 AND 2021),
	UB_MH number CONSTRAINT JSMUSER_UB_MH_CK CHECK(UB_MH BETWEEN 1 AND 12),
	UB_DY number CONSTRAINT JSMUSER_UB_DY_CK CHECK(UB_DY BETWEEN 1 AND 31)
);

-- 회원가입 SQL문
INSERT INTO JSMUSER values(
	'citybang',  -- ID
	'cy7272',    -- PW
	'bangbang@gmail.com',  -- EMAIL
	1980,  -- BIRTH_YEAR
	7, 	   -- BIRTH_MONTH
	2	   -- BIRTH_DAY
);
	
INSERT INTO JSMUSER values('goodgirl', 'as1234', 'good1@naver.com', 2000, 4, 20);
INSERT INTO JSMUSER values('hismile', 'as1234', 'smile@naver.com', 2021, 6, 28);

-- 로그인 SQL문
SELECT UID0 아이디, UPW 비밀번호, UEMAIL 이메일, 
	UB_YR "생일(연)", UB_MH "생일(월)", UB_DY "생일(일)"
FROM JSMUSER
WHERE UID0 = 'himan01' AND UPW = 'qw7777';


SELECT UID0 아이디, UPW 비밀번호, UEMAIL 이메일, 
	UB_YR "생일(연)", UB_MH "생일(월)", UB_DY "생일(일)"
FROM JSMUSER;


-- 아이디 찾기 SQL문
SELECT UID0 아이디, UPW 비밀번호, UEMAIL 이메일, 
	UB_YR "생일(연)", UB_MH "생일(월)", UB_DY "생일(일)"
FROM JSMUSER
WHERE UEMAIL = 'bangbang@gmail.com';


-- 비밀번호 찾기 SQL문
SELECT UID0 아이디, UPW 비밀번호, UEMAIL 이메일, 
	UB_YR "생일(연)", UB_MH "생일(월)", UB_DY "생일(일)"
FROM JSMUSER
WHERE UID0 = 'goodgirl'
AND UEMAIL = 'good1@naver.com';


-- 개인정보 수정 SQL문
UPDATE JSMUSER 	
	SET UPW = 'qw1234'
	WHERE UID0 = 'himan01'
	AND UPW = 'qw7777';


SELECT * FROM JSMUSER;


-- 회원탈퇴 SQL문
delete FROM JSMUSER
WHERE UID0 = 'himan01'
AND UPW = 'qw1234';

/*
-- 0712 응용문제 풀이용
SELECT * FROM PRODUCT;

DROP TABLE product;

CREATE TABLE product(
	pname varchar2(30),
	pprice NUMBER,
	pcnt number
);

INSERT INTO product values('포스트잇', 2000, 5);
INSERT INTO product values('연필', 800, 10);
INSERT INTO product values('필통', 5000, 2);


-- 선생님 풀이용 테이블
CREATE TABLE product (
	pno char(7),
	name varchar2(50),
	price number,
	cnt number
);

CREATE SEQUENCE prod_seq 
	START WITH 1000
	MINVALUE 1000
	MAXVALUE 9999;

INSERT INTO product values('PRO'||prod_seq.nextval, '사과', 2000, 300);
INSERT INTO product values('PRO'||prod_seq.nextval, '바나나', 4500, 500);
INSERT INTO product values('PRO'||prod_seq.nextval, '딸기', 12000, 200);
INSERT INTO product values('PRO'||prod_seq.nextval, '수박', 15000, 500);

INSERT INTO product values('PRO'||prod_seq.nextval, ?, ?, ?);

-- 검색용 가격 조회도 포함
SELECT *
FROM product 
WHERE name LIKE '%'||''||'%'
AND price BETWEEN 0 AND 9999;

SELECT *
FROM product 
WHERE name LIKE '%'||'?'||'%'
AND price BETWEEN ? AND ?;

UPDATE product
	SET name = '딸기(특)',
		price = 15000,
		cnt = cnt + 100
	WHERE pno = 'PRO1002';
	
UPDATE product
	SET name = ?,
		price = ?,
		cnt = ?
	WHERE pno = ?;


*/

-- 회원번호, 회원ID, 회원PW, 이메일, 사용권한
CREATE TABLE wmember (
	memno varchar2(50),
	memId varchar2(50),
	memPw varchar2(50),
	memEmail varchar2(100),
	memAuth number
);

INSERT INTO wmember values('nm001', 'himan', '7777', 'himan@naver.com', 10);

SELECT * FROM wmember;
