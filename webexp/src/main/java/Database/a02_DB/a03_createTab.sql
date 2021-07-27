
/*

#테이블에 사용되는 데이터 타입
1. 개요
	1) 데이터베이스에 저장되는 데이터는 문자, 숫자, 날짜, 이미지 등과 같은
		다양한 형식으로 표현된다.
		cf) 이미지는 binary 타입으로 설정하기보다 이미지 파일 서버를
		활용해서 이미지 경로와 파일을 활용해서 저장한 위치를 호출한다
		varchar2로 저장한다. 설계시 이미지명과 경로명까지 처리된다는 것을
		설계에 포함
		
	2) 실무에서 컬럼에 대한 데이터 타입이나 길이의 결정은 데이터 베이스 
		설계 단계에서 신중하게 고려해야하는 중요한 사항이다.
	3) 데이터베이스 설계 단계에서 잘못 선정된 데이터 타입은 응용 프로그램
		개발을 어렵게 하거나 성능을 저하시키는 요인이 된다.
2. 오라클에서 지원되는 데이터 타입의 종류
	1) char(size) : 고정 길이 문자 데이터 타입. 최대 2000바이트
		입력시 남은 공간에는 공백으로 채워진다. 
		ex) 코드성 데이터 - 학번/사번/주민번호 : 자리 수가 정해진 데이터
		create table personnel (
			sivilnum char(13);
		);
	2) varchar2(size) : 가변 길이 문자 데이터 타입. 최대 4000바이트
		입력시 남은 공간이 없는 가변 공간이므로 할당한 크기만큼만 만들어진다.
		ex) 최대 크기를 설정하기에 그보다 작은 데이터 할당시 효율화
		create table personnel (
			name varchar2(15);
		);
	3) number(p,s) : 정밀도(P)와 스케일(s)로 표현되는 숫자 데이터 타입
		ex) 전체크기 소숫점 이하 크기 지정
	4) date : 날짜/시간 형식을 저장하기 위한 데이터 타입
	5) navarchar2(size) : 국가별 문자 집합에 따른 size크기의 문자/바이트
		문자 데이터 타입
	6) rowid : 테이블 내 행의 고유 주소를 가지는 64진수 문자 타입
		행단 6바이트 또는 10바이트
	7) blob : 대용량의 바이너리 데이터를 저장하기 위한 데이터 타입으로 최대 4GB
	8) clob : 대용량의 텍스트 데이터를 저장하기 위한 데이터 타입으로 최대 4GB
	9) bfile : 대용량의 바이너리 데이터를 파일 형태로 저장하기 위한 데이터타입으로 최대 4GB
	10) timestamp(n) : date 데이터 타입의 확장된 형태. n은 millis seconde 
		자리수로 최대 9자리까지 표현 가능.

3. 기타 제약조건
	1) primary key 
	2) unique 
	3) not null
	4) check
	5) foreign key
	
4. 실무 설계
	1) 컬럼내의 연산으로 결과값이 나오는 데이터는 컬럼에서 제외한다.
		학생정보의 국어, 영어, 수학 점수에서 합계나 평균 등은 테이블
		설계의 내용에서 제외한다.
	2) 테이블의 분리가 필요한 경우에서 하나의 테이블에서 처리하지 않고
		분리를 한다 - 분리 기준은 join 구문시 언급 
*/


-- 회원 정보 테이블 생성
CREATE TABLE MEMBER (
	id varchar2(20), -- 가변 데이터
	pass varchar2(20),
	civilcode char(13),  -- 고정형 데이터
	point NUMBER, -- 기본 정수형 데이터
	auth varchar2(20)
);

-- 이번 조별과제는 테이블을 만들고 샘플데이터를 입력한 수준으로 만들기



/*
  
#데이터 입력
insert into 테이블명 values('입력할 데이터' ...) 
- 테이블의 구조를 순서대로 입력
 
*/


INSERT INTO MEMBER VALUES('himan', '7777', '1234567543', 1000, '관리자');

SELECT * FROM MEMBER;


-- 응용) 프로야구 팀정보를 입력하려고 한다.
-- 		구글에 프로야구 순위표를 확인하고
--		해당 데이터를 입력하기 위한 테이블을 만들고 데이터를 입력한 후 조회하기 (4조)

CREATE TABLE Kbaseball (
	name varchar2(20), 
	outcome varchar2(10),
	winrate number(15),
	behind number(15)
);

-- 소숫점 입력
CREATE TABLE Kbaseball2 (
	name varchar2(20), 
	outcome varchar2(10),
	winrate number(15,3),
	behind number(15,2)
);

ALTER TABLE Kbaseball2 MODIFY behind number(15, 1) AFTER behind;

INSERT INTO Kbaseball values('SSG', '승', 0.555, 2.0); 
INSERT INTO Kbaseball values('KT', '패', 0.556, 2.0);

-- 소숫점 입력
INSERT INTO Kbaseball2 values('SSG', '승', 0.555, 2.0); 
INSERT INTO Kbaseball2 values('KT', '패', 0.556, 2.0); 

SELECT *
FROM Kbaseball;

SELECT *
FROM Kbaseball2;

-- 테이블 삭제
DROP TABLE KbaseBall;
DROP TABLE KbaseBall2;

-- 풀이!
-- 숫자형 만드는거에도 애먹었는데 걍 NUMBER로 선언하면 되는거였음
CREATE TABLE baseTeam (
	tname varchar2(20),
	vic NUMBER,
	def NUMBER,
	eq NUMBER
);

INSERT INTO baseTeam values('키움', 80, 63, 1);

-- 승률은 앞에서 입력되는 승패를 기준으로 만들어지는거라서 테이블 속성으로 만들지 X
SELECT tname 팀, vic 승, def 패, eq 무,
		vic/(vic+def) 승률
FROM baseTeam;