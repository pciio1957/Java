
/*

# 정리문제
1. 테이블 subquery에서 테이블간 조인관계를 
    급여가 2000이상인 사원테이블, 부서명이 SALES 이거나 RESEARCH 부서테이블 조인하여
    사원명, 부서명, 급여를 출력하세요.
    (아래)
    
2. 직책별 최고급여자의 부서번호, 부서명을 출력하세요.
	(아래.. )
	
3. DB 조작어의 종류와 트랜잭션 명령어의 기능에 대하여 기술하세요.
	DML(Data Manipulation Language)
	1. 종류 
		1) insert : 데이터 입력처리
		2) update : 데이터 수정처리
		3) dalete : 데이터 삭제처리
		4) merge : 데이터 병합처리(논리적 테이블의 병합/수정을 동시에 입력한다)
		
	2. 트랜잭션 명령어의 기능
		여러 개의 명령문을 하나의 논리적인 작업단위로 처리하는 기능을 말한다.
		종류
			1) commit : 정상종료 확정, 접속한 session 단위로 DML처리를 확정하는 것을
					말하고 다른 접속 session에서 영향을 미친다. 
			2) rollback : 비정상종료 복구, commit 전에는 rollback을 통하여 복구할 수 있다.
			

4. 데이터 입력의 기본형식 중, 단일 행입력, 다중행 입력을 기본예제를 통해서 설명하세요.
	1) 단일행 입력 
		insert into 테이블명(컬럼1, 컬럼2 ...) values(데이터1, 데이터2...)
		insert into 테이블명 values(테이블 구조 순서에 따른 데이터1, 데이터2...)
	2) 다중행 입력
		insert all(first)
		into 테이블명 values(데이터1, 데이터2.. )
		
		insert all(first)
		into 테이블명(컬럼1, 컬럼2..) values(데이터1, 데이터2..)
		subquery;


5. 데이터 입력 중, 여러테이블의 한번에 subquery 입력을 기본예제를 통해서 설명하세요.
	(아래)
	
6. emp04 테이블에 사원번호, 사원명, 입사일(2020/01/01 오전 11:30), 급여를 입력하세요.
	(아래)
7. 직급별 최고연봉과 최저연봉을 입력받을 수 있는 구조 테이블을 만들고, 해당 테이블에 emp 테이블의
    정보를 subquery로 입력하세요.
    (아래)
    
8. emp17, emp18, emp19 테이블을 emp테이블의 구조테이블로 만들고, 
    부서별 최고급여자의 사원정보전체를 가져와서 해당테이블에 입력하되, 
    emp17에는 부서번호 최고급여
    emp18에는 부서번호+1 최고급여*5
    emp19에는 부서번호+2 최고급여*10 을 처리하여 입력하세요.

	(아래 풀이도 있고, 선생님이 푸신 부분도 첨부)
	
    
*/

-- 1. 
SELECT ename, dname, a.sal 
FROM (SELECT *
	FROM emp 
	WHERE sal >= 2000) a, (
	SELECT *
	FROM dept 
	WHERE dname = 'SALES'
	OR dname = 'RESEARCH') b 
WHERE a.deptno = b.deptno;

-- 조건1
SELECT ename, sal
FROM emp 
WHERE sal >= 2000;

-- 조건2
SELECT *
FROM dept 
WHERE dname IN ('SALES', 'RESEARCH');

-- 조인
SELECT ename, sal, dname
FROM (SELECT ename, sal, deptno
	FROM emp 
	WHERE sal >= 2000) e, 
	(SELECT *
	FROM dept 
	WHERE dname IN ('SALES', 'RESEARCH')) d 
WHERE e.deptno = d.deptno;



-- 2. 직책별 최고급여자의 부서번호, 부서명 (모르겠음)
-- 왜인지 뭔가 부족하다고 생각했는데 3개를 조인하는것
-- 최종적으로 필요한 값 : job, sal, deptno, dname
SELECT b.deptno, dname
FROM (SELECT job, max(sal) sal
	FROM emp 
	GROUP BY job)a, dept b 
WHERE a.deptno = b.deptno;

-- 1직책별 최고급여자
SELECT job, max(sal) sal
FROM emp 
GROUP BY job;

-- 2중간테이블
SELECT job, sal, deptno
FROM emp;

-- 3부서정보
SELECT deptno, dname
FROM dept;

-- 3개 합치기
SELECT a.job, a.sal, b.deptno, c.dname
FROM (SELECT job, max(sal) sal
	FROM emp 
	GROUP BY job) a,
	(SELECT job, sal, deptno 
	FROM emp) b, dept C 
WHERE a.job = b.job 
AND a.sal = b.sal 
AND b.deptno = c.deptno;

-- 4. 
CREATE TABLE emp33 AS SELECT * from emp WHERE 1 = 0; 

-- 단일행 
INSERT INTO emp33 values(1000, '홍길동', '사원', 
	9999, sysdate, 3000, 1000, 10);	
	
-- 다중행
INSERT ALL
INTO emp33(ename, sal) values('김길동', 3000)
INTO emp33(ename, sal) values('이길동', 1000)
INTO emp33(ename, sal) values('박길동', 2000)
SELECT ename, sal 
FROM emp;



-- 6. 
INSERT INTO emp04(empno, ename, hiredate, sal)
values(7800, '홍길동', to_date('2020/01/01 AM 11:30',
	'YYYY/MM/DD AM HH:MM') , 3000);
	

-- 7.
CREATE TABLE emp001
SELECT job, max(sal) xsal, min(sal) nsal 
FROM emp 
GROUP BY job 
HAVING 1=0;

INSERT ALL
INTO emp001 values(job, xsal, nsal)
SELECT job, max(sal) xsal, min(sal) nsal 
FROM emp 
GROUP BY job;


-- 8.
CREATE TABLE emp17 
AS select * FROM emp WHERE 1=0;
CREATE TABLE emp18 
AS select * FROM emp WHERE 1=0;
CREATE TABLE emp19
AS select * FROM emp WHERE 1=0;

-- 급여 크기가 작아서 emp17,18,19테이블로 가서 sal의 크기를 number(15,2)로 변경후 진행
-- 부서별
SELECT b.* 
FROM (SELECT deptno, max(sal) sal FROM emp GROUP BY deptno) a,
emp b 
WHERE a.deptno = b.deptno
AND a.sal = b.sal;



-- 선생님 올려주신 풀이 
-- 8. emp17, emp18, emp19 테이블을 emp테이블의 구조테이블로 만들고, 
--    부서별 최고급여자의 사원정보전체를 가져와서 해당테이블에 입력하되, 
--    emp17에는 부서번호 최고급여
--    emp18에는 부서번호+1 최고급여*10
--    emp19에는 부서번호+2 최고급여*20 을 처리하여 입력하세요.
CREATE TABLE emp17
AS SELECT * FROM emp WHERE 1=0;
CREATE TABLE emp18
AS SELECT * FROM emp WHERE 1=0;
CREATE TABLE emp19
AS SELECT * FROM emp WHERE 1=0;
-- 부서별 최고급여자의 사원정보전체
SELECT b.*
FROM (SELECT deptno, max(sal) sal FROM emp GROUP BY deptno) a,
    emp b
WHERE a.deptno = b.deptno
AND a.sal = b.sal;


INSERT ALL
INTO emp17 values(empno, ename, job, mgr, hiredate, sal, comm, deptno)
INTO emp18 values(empno, ename, job, mgr, hiredate, sal*10, comm, deptno+1)
INTO emp19 values(empno, ename, job, mgr, hiredate, sal*20, comm, deptno+2)
SELECT b.*
FROM (SELECT deptno, max(sal) sal FROM emp GROUP BY deptno) a,
    emp b
WHERE a.deptno = b.deptno
AND a.sal = b.sal;