
/*

#데이터 조작어(Data Manipulation Language)
1. 테이블에 새로운 데이터를 입력하거나 기존 데이터를 수정 또는 삭제하기 위한 명령어이다.

2. 종류
	1) insert : 입력 처리
	2) update : 수정 처리
	3) delete : 삭제 처리
	4) merge : 병합처리(논리적 테이블의 병합/수정을 동시에 입력)
	
3. 트랜잭션
	여러 개의 명령문을 하나의 논리적인 작업단위로 처리하는 기능을 말한다.
	명령어 종류 : commit(정상종료 확정), rollback(비정상종료 복구)
	ex) DB클라이언트가 접속해서 변경했을때 본인 계정으로만
		변경된 데이터가 보인다(다른 계정으로 접근하면 변경되지 않는 데이터가 보임)
		이때 commit하는 순간 현재 클라이언트뿐만 아니라 다른 계정으로 
		접속하더라도 변경되게 처리된다.
		

#데이터 입력 처리
1. 테이블에 데이터를 입력하기 위한 명령어 insert 구문을 말한다.

2. 입력방법
	1) 단일행 입력 : 한번에 하나의 행을 테이블에 입력하는 구문
	2) 다중행 입력 : 서브 쿼리(subquery)를 이용해서 한번에
		여러 행을 동시에 입력하는 구문
	
3. 단일행 입력 방법
	1) 기본 구문
		insert into 테이블명(컬럼1, 컬럼2 ...) values(데이터1, 데이터2...);
		insert into 테이블명 values(테이블 구조 순서에 따른 데이터1, 데이터2...);  
	
4. 다중행 입력 방법
	1) 데이터를 하나의 테이블에 여러 행을 한 번에 입력하는 query를 말한다.
	2) 형식 
		insert 명령문에서 서버퀄리로 다른 테이블에서 조회해와서 입력 처리
		insert 명령문에 의해 한 번에 여러행을 동시에 입력 
		
		-기타형식
		1. 전체 컬럼 입력 : insert into 테이블명 subquery
		2. 지정된 컬럼 입력 : insert into 테이블명(컬럼1, 컬럼2....)
				해당 컬럼의 갯수와 type에 맞는 subquery임

	
#복사테이블 만드는 방법 
1. 구조와 데이터를 모두 복사하는 방법 
	create table 테이블명 
	as select * from 테이블명; 
	- 제약조건을 제외한 구조와 데이터를 모두 복사해 새로운 테이블 생성 
	
2. 구조만 복사하는 방법
	create table 테이블명
	as select * from 테이블명 where 1 = 0; 
	- 제약조건을 제외한 구조만 복사하여 새로운 테이블 생성 
	
3. 특정 컬럼만 지정해서 만드는 방법
	create table 테이블명
	as select 컬럼1, 컬럼2, 컬럼3 from 테이블
	해당 테이블에 특정 컬럼만 지정해서 새로운 테이블 생성
	
	

#날짜 데이터 처리
1. sysdate : 현재 날짜/시간으로 date타입 컬럼에 현재 날짜/시간을 입력한다.
2. to_date('문자열데이터', '문자열데이터의 입력형식'
	문자열 데이터를 지정된 입력양식에 맞게 date타입 컬럼에 날짜/시간 입력
	ex) to_date('2021/06/23' , 'YYYY/MM/DD')
	
	
	
#null 데이터 처리
	1) 명시적으로 null을 선언해서 데이터처리
	2) 컬럼 지정시 해당 null을 선언할 컬럼을 지정하지 않음 
	
	
	
#하나의 sql로 여러 테이블 입력처리
1. 서버쿼리의 결과 집합을 조건없이 여러 테이블에 동시에 입력
2. 형식 
	insert all|first : all(전체), first(첫번째 데이터)
	into 테이블1 values(컬럼명1, 컬럼명2...)
	into 테이블2 values(컬럼명1, 컬럼명2...)
	into 테이블3 values(컬럼명1, 컬럼명2...)
	서버 쿼리;
	
	// 서버쿼리를 통해서 나온 sql문에 전체 혹은 첫번째 데이터에 값을 입력하겠다 
	
	
*/

-- 복사테이블 만드는 3가지 방법
CREATE TABLE emp03
AS SELECT * FROM emp;

SELECT * FROM emp03; 

CREATE TABLE emp04 
AS SELECT * FROM emp WHERE 1 = 0; 

SELECT * FROM emp04;

CREATE TABLE emp05 
AS SELECT ename, job, sal, deptno FROM emp;

SELECT * FROM emp05;



-- 날짜데이터 처리
-- 1. 전체 데이터 입력
INSERT INTO emp04 values(1000, '홍길동', '사원', 
	9999, sysdate, 3000, 1000, 10);	
	
SELECT * FROM emp04;

COMMIT; -- commit해야 지정됨

-- 2. 특정 컬럼에 데이터 입력
-- insert into 테이블명(컬럼명1, 컬럼명2...)
INSERT INTO emp04(empno, ename, sal, hiredate)
	value(1001, '마길동', 4000, to_date('2000/06/06', 'YYYY/MM/DD'));
	
SELECT * FROM emp04;


-- 응용1) 부서정보 테이블의 복사테이블을 만들고 전체데이터 입력과
--		특정 컬럼(부서번호, 부서명) 지정 데이터 입력을 처리하기 (1조)
-- 전체 데이터 복사
CREATE TABLE dept01
AS SELECT * FROM dept;

SELECT * FROM dept01;

INSERT INTO dept01 values(50, 'SALES2', 'LONDON');
INSERT INTO dept01(deptno, dname) values(60, 'SALES3');

CREATE TABLE dept02 
AS SELECT deptno, dname FROM dept;

SELECT * FROM dept02;



-- null 데이터 처리
INSERT INTO dept01 values(51, NULL, 'LONDON');
INSERT INTO dept01(deptno, loc) values(52, '서울강남');
SELECT * FROM dept01;

-- 응용2) 사원정보와 부서정보를 혼합 테이블 emp_dept을 복사테이블로 만들고 
--		null을 이용해서 입력한 데이터와 컬럼을 통해 
-- 		자동 null 처리된 데이터를 입력처리하기 (2조)

CREATE TABLE emp_dept 
AS SELECT e.ename,d.deptno, d.dname, e.sal, e.MGR FROM emp e, dept d WHERE e.deptno = d.deptno;

INSERT INTO emp_dept values('CHALS', 30, 'SALES4', 3000, null);
INSERT INTO emp_dept(ename, deptno, dname) values('MICKY', NULL, null);

SELECT * FROM emp_dept;

-- 풀이 : join문을 사용해서 생성
CREATE TABLE emp_dept2
AS SELECT e.*, dname, loc 
FROM emp e, dept d 
WHERE e.deptno = d.deptno;

SELECT * FROM emp_dept2;

INSERT INTO emp_dept2 values(7999, '홍길동', '사원', 7782,
	sysdate, 1000, NULL, 60, '인사팀', '강남');
INSERT INTO emp_dept2(empno, ename, deptno, dname) values(7888, '마길동', 70, '재무팀');


-- 응용3) 부서별 최고급여, 최저급여, 평균급여로 복사테이블(emp_sta)을 만들고
-- 		null 명시, 컬럼지정 null 처리하기 (2조, 3조)
CREATE TABLE emp_sta 
AS SELECT max(sal) bsal, min(sal) ssal, avg(sal) asal
FROM emp 
GROUP BY deptno;

SELECT * FROM emp_sta;

INSERT INTO emp_sta values(1200, 1000, null);
INSERT INTO emp_sta(ssal, asal) values(2000, 2000);

-- 풀이
CREATE TABLE emp_sta2
AS SELECT deptno, max(sal) msal, 
	minsal(sal) isal,
	avg(sal) asal
FROM EMP 
GROUP BY deptno;

SELECT * FROM emp_sta2;

INSERT INTO emp_sta2 values(40, NULL, 1000, null);
INSERT INTO emp_sta2(deptno, asal) VALUES(50, 3000.27); 


-- 다중행 입력 처리 
-- 1. 전체 컬럼 입력 : insert into 테이블명 subquery
-- 2. 지정된 컬럼 입력 : insert into 테이블명(컬럼1, 컬럼2....)
--			해당 컬럼의 갯수와 type에 맞는 subquery임
SELECT * FROM emp01;

INSERT INTO EMP01 
SELECT *
FROM EMP e 
WHERE sal BETWEEN 3000 AND 5000;

-- 부서별로 최근에 입사한 사람을 지정한 컬럼에 삽입
INSERT INTO emp01(deptno, hiredate)
SELECT deptno, max(hiredate)
FROM EMP e 
GROUP BY deptno;

SELECT * FROM emp01;


-- 응용1) emp의 구조만 복사된 emp10 복사테이블을 만들고
--  emp테이블에서 부서번호가 10인 데이터를 subquery로 emp10에 입력하기
-- 응용2) emp 테이블에서 직책별 최고급여를 emp10 테이블에 입력처리하기(4조) 


CREATE TABLE emp10 
AS SELECT * FROM emp WHERE 1=0;

SELECT * FROM emp10;

INSERT INTO emp10 
SELECT * 
FROM emp 
WHERE deptno = 10;

-- 2번 안됨 : select하는 데이터가 job, sal이니까 
-- 값이 들어가는 컬럼 지정을 해줘야함. emp10(job, sal) 이런식.
INSERT INTO emp10(job, sal)
SELECT job, max(sal)
FROM emp 
GROUP BY job;


-- 하나의 sql문으로 여러 테이블 입력 처리 
CREATE TABLE emp05 AS SELECT * FROM emp WHERE 1 = 0;
CREATE TABLE emp06 AS SELECT * FROM emp WHERE 1 = 0;
CREATE TABLE emp07 AS SELECT * FROM emp WHERE 1 = 0;


SELECT * FROM emp05;
SELECT * FROM emp06;
SELECT * FROM emp07;

-- 테이블 삭제시 drop 사용
DROP TABLE emp05;
DROP TABLE emp06;
DROP TABLE emp07;

-- 부서번호가 10인 데이터들을 5,6,7에 삽입
INSERT ALL
INTO emp05(empno, ename, sal) values(empno, ename, sal)
INTO emp06(empno, ename, sal) values(empno, ename, sal)
INTO emp07(empno, ename, sal) values(empno, ename, sal)
SELECT empno, ename, SAL 
FROM emp 
WHERE deptno = 10;


-- 응용1) emp08, emp09, emp11 테이블을 emp의 구조를 복사하고 
-- 		emp 테이블의 급여가 2000~ 4000 사이의 데이터만 
--		emp의 ename, sal, hiredate를 각각 테이블에 입력처리하기(5조) 
CREATE TABLE emp08 AS SELECT * from emp WHERE 1 = 0; 
CREATE TABLE emp09 AS SELECT * from emp WHERE 1 = 0; 
CREATE TABLE emp11 AS SELECT * from emp WHERE 1 = 0; 

INSERT ALL
INTO emp08(ename, sal, hiredate) values(ename, sal, hiredate)
INTO emp09(ename, sal, hiredate) values(ename, sal, hiredate)
INTO emp11(ename, sal, hiredate) values(ename, sal, hiredate)
SELECT ename, sal, hiredate
FROM emp 
WHERE sal BETWEEN 2000 AND 4000;

SELECT * FROM emp08;
SELECT * FROM emp09;
SELECT * FROM emp11;


-- 응용2) emp12, emp13, emp14로 부서번호, 최근입사일1, 최초입사일로 구조만 복사한 테이블을 만들고
--		emp의 부서별, 최근입사일, 최초입사일 데이터를 입력처리하기 (1조)

-- 여기서 조건이 잘못된거였나봄 group by가 있어서 where이 아닌 having으로 줘야함
CREATE TABLE emp12 AS SELECT deptno, max(hiredate) mhire, min(hiredate) nhire 
FROM emp GROUP BY deptno HAVING 1=0;
CREATE TABLE emp13 AS SELECT deptno, max(hiredate) mhire, min(hiredate) nhire 
FROM emp GROUP BY deptno HAVING 1=0;
CREATE TABLE emp14 AS SELECT deptno, max(hiredate) mhire, min(hiredate) nhire 
FROM emp GROUP BY deptno HAVING 1=0;

-- group by된 곳에 그룹함수(max, min등 사용하면 안된다고 하는데 어떻게 하는건지)
INSERT all
INTO emp12 values(deptno, mhire, nhire)
INTO emp13 values(deptno, mhire, nhire)
INTO emp14 values(deptno, mhire, nhire)
SELECT deptno, max(hiredate) mhire, min(hiredate) nhire
FROM emp
GROUP BY deptno;

SELECT * FROM emp12;
SELECT * FROM emp13;
SELECT * FROM emp14;

DROP TABLE emp12;
DROP TABLE emp13;
DROP TABLE emp14;
