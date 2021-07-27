
/*

#데이터 무결성 제약조건의 개념
1. 데이터의 정확성과 일관성을 보장

2. 데이터 정확성을 유지하여 다양한 종류의 업무규칙을 고려함
	1) student 테이블에서 학년 데이터는 1, 2, 3, 4 중의 하나만 입력
	2) 모든 학번은 유일하게 처리
	3) student 테이블의 지도교수 번호는 progessor 테이블의 교수번호 중의 하나와 반드시 일치

3. 데이터 무결성 제약조건의 장점
	1) 테이블 생성시 무결성 제약조건을 정의 가능
		- 생성 후 제약조건 설정도 가능
	2) 테이블에 대해 정의, 데이터 딕셔너리에 저장되므로
		응용 프로그램에서 입력된 모든 데이터에 대해 동일하게 적용
	3) 제약조건을 활성화, 비활성화할 수 있는 융통성이 있다.

4. 무결성 제약조건의 종류
	1) not null : 열이 null을 포함할 수 없음
	2) unique key : 테이블의 모든 행에서 고유한 값을 갖는 열 또는 열조합을
		지정해야한다. 
		ex) 학번, 주민번호, 사원번호가 중복되지 않아야한다.
		ps) null은 입력가능하고 여러가지 null은 중복가능 
	3) primary key : 해당 컬럼 값은 반드시 존재해야 하며 유일해야한다
		not null과 unique가 결합된 형태이다.
		주로 테이블에서 식별해야할 컬럼 즉, key를 설정할 때 사용된다.
		ex) emp테이블의 empno, dept테이블의 deptno가 있다.
	4) foreign key : 한 열과 참조된 테이블의 열간에 외래 키 관계를 설정하고 시행
		ex) 사원의 테이블의 부서번호는 반드시 부서테이블에 있는 부서번호여야한다. 
	5) check : 해당 컬럼에 저장 가능한 데이터 값의 범위나 조건을 지정처리
	ex) student 테이블의 학년을 1, 2, 3, 4만 데이터로 넣을 수 있다.
	
5. 설정 형식
	1) 컬럼명 데이터타입 constraint 제약조건명 제약조건
		제약조건명 : 테이블명_컬럼명_제약조건종류
		
	2) primary key 지정
	 	ex) create table student(
	 		stuno number constraint student_stuno_pk primary key
	 		); 
	 		
	 		제약조건 이름 : 테이블명_컬럼명_제약조건종류
	 		제약조건 종류: pk, uq, nn, fk 

*/
-- 설정한 제약조건들을 확인할 수 있다 
-- DB시스템에 있는 제약조건의 메타테이블 
SELECT * FROM SYS.all_constraints;

-- emp테이블에 설정한 제약조건 확인
SELECT * 
FROM SYS.all_constraints
WHERE table_name LIKE 'EMP%';

-- not null : 입력이 안되면 오류가 남
CREATE TABLE student01(
	name varchar2(30) CONSTRAINT student01_name_nn NOT NULL 
);

INSERT INTO student01 values('홍길동');
INSERT INTO student01 values('김길동');

-- 제약조건이 not null인데 null 삽입시 에러남
-- 에러 : ORA-01400: cannot insert NULL into ("SCOTT"."STUDENT01"."NAME")
INSERT INTO student01 values(null);

SELECT * FROM student01;


-- 응용) student2 테이블에 학생번호와 이름, 국어 점수를 입력할 컬럼을 지정하되
-- 		학생번호는 제약조건으로 not null을 설정하고 데이터 입력을 통해 확인하기 (3조)
CREATE TABLE student02(
	stuno NUMBER CONSTRAINTS student02_stuno_nn NOT NULL,
	name varchar2(30),
	kor number
);

DROP TABLE student02;

INSERT INTO student02 values(1, '홍길동', 70);
INSERT INTO student02 values(2, '김길동', null); -- 다른곳 null은 가능
INSERT INTO student02 values(null, '나길동', 30); -- NOT NULL 설정한 곳만 에러

SELECT * FROM student02;


-- unique : 다른 데이터와 식별되게 입력, 동일한 데이터 입력시 에러 발생
--		null 값은 중복이 가능하지만(2중이상) 동일하게 입력한 데이터의 중복은 안됨 

CREATE TABLE student03(
	sno number(5) CONSTRAINTS student03_sno_uq unique
);

INSERT INTO student03 values(1);
INSERT INTO student03 values(3);
INSERT INTO student03 values(null);
INSERT INTO student03 values(1); -- 중복안됨

SELECT * FROM student03;


-- 응용) employee04에 사원번호, 사원명, 급여를 설정하고 사원번호에는 unique 설정
--		사원명은 not null로 제약조건을 설정하고 데이터 입력과 출력하기 (4조)
CREATE TABLE employee04(
	eno NUMBER CONSTRAINTS employee04_eno_uq UNIQUE,
	ename varchar2(30) CONSTRAINTS employee04_ename_nn NOT NULL ,
	sal NUMBER 
);

INSERT INTO employee04 values(1, '홍길동', 2000);
INSERT INTO employee04 values(1, '김길동', 2000); -- eno의 unique
INSERT INTO employee04 values(NULL, NULL, null); -- ename의 NOT null
INSERT INTO employee04 values(2,'주길동', null);
INSERT INTO employee04 values(3, NULL, 3000); -- ename의 NOT null


-- 일반적으로 테이블의 각 행단위를 식별할 수 있는 식별자는 보통 key로 사용하는 컬럼이 존재한다. 
-- key로 사용되는 컬럼은 유일해야하고, null을 입력하지 않아야하는 조건으로 위에서 선언한
-- 2가지 제약조건이 다 필요하다. 
-- 이때 사용하는 제약조건이 primary key 이다.

SELECT * FROM emp;

-- 제약조건의 이름이 지정되지 않은 상태로 테이블 생성
CREATE TABLE employee05(
	empno number(4) PRIMARY KEY -- 제약조건의 이름이 지정되지 않는다	
);

-- 제약조건의 이름을 지정한 상태로 테이블 생성
CREATE TABLE employee06 (
	emono number(4) CONSTRAINTS employee06_empno_pk PRIMARY KEY 
);

-- primary key 조건: 유일하고 중복되지 않음, null이 아니어야함
INSERT INTO employee06 values(1000);
INSERT INTO employee06 values(1001);
INSERT INTO employee06 values(1001); -- 중복
INSERT INTO employee06 values(null); -- null

-- 응용) student04 테이블에 학번(primary key), 이름(not null), 국어,
--		영어, 수학 점수로 테이블을 구성하고 데이터 입력 후 출력하기 (5조)

CREATE TABLE student04 (
	stuno NUMBER CONSTRAINTS student04_stuno_pk PRIMARY KEY,
	sname varchar2(30) CONSTRAINTS student04_sname_nn NOT NULL,
	kor NUMBER,
	eng NUMBER,
	math number
);

INSERT INTO student04 values(1, '홍길동', 20, 30, 40);
INSERT INTO student04 values(1, '유길동', 20, 30, 40); -- pk의 중복
INSERT INTO student04 values(2, '무길동', 20, 30, 40);
INSERT INTO student04 values(3, null, 20, 30, 40); -- nn의 NULL 삽입
INSERT INTO student04 values(4, '여길동', null, null, null); -- 일반값의 NULL 삽입
