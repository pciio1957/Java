
/*

#정리문제
1. 집합형 sql 종류를 기본예제와 함께 기술하기 
	집합형 sql의 연산종류 
	1) union : 합집합 - 두 sql의 결과 공통데이터는 1번만 나와서 
		처리결과를 확인할 수 있다.
	2) union all : 합집합이지만 중복된 데이터를 처리결과로 확인할 수 있다.
	3) intersect : 교집합으로 두 개의 집합의 공통되는 집합을 출력한다.
	4) minus : 차집합으로 먼저 위치한 select문을 기준으로 
		다른 select문과 공통된 데이터를 제외한 항목만 추출

2. view의 장점을 기술하고, 직책별 최고 급여자의 사원정보를 뷰로 작성하세요.
	view의 장점 
	1) 보안적인 필요성 : 데이터를 보호할 수 있다
		- 지정된 권한이 있는 사람만 전체 테이블을 활용하고
		그 외의 사람들은 뷰를 통해서 허용된 컬럼만 조회하도록 한다
	2) 편의적인 필요성 : 사용자 편의성 지원
		- 다른 테이블과 join하거나 group함수 등을 통해서 
		뷰를 통해서 간단하게 조회할 수 있다 
		- 복잡한 sql문을 하나의 가상테이블로 만들어 
		조회할 수 있기 때문에 편의성이 증대된다. 
		
	
	1) 보안적인 필요성으로 특정 테이블의 특정 컬럼만 보이게 처리할 수 있다
	2) 사용자 query작성 편의성. 복잡한 쿼리를 하나의 단순한 view로 만들어서
		효과적으로 쿼리를 구현할 수 있다.

3. 뷰의 제약사항을 단순뷰와 복합뷰를 나누어 기술하세요.
	뷰의 제약사항 
		distinct 사용여부, group함수 사용여부, DML 사용여부
	
	1) 단순 뷰
		하나의 테이블로 생성
		group함수 사용여부 : 불가능 
		distinct 사용여부 : 불가능 
		dml 사용여부 : 가능
	
	2) 복합 뷰
		여러 개의 테이블로 생성
		group함수 사용여부 : 가능
		distinct 사용여부 : 가능
		dml 사용여부 : 불가능 

*/


-- 1. 
SELECT * FROM emp;

-- 1) union: 합집합으로 두 결과의 중복된 데이터는 제외 후 공통데이터를 출력한다 
SELECT ename, sal 
FROM emp 
WHERE job = 'SALESMAN'
UNION 
SELECT ename, SAL 
FROM emp 
WHERE sal BETWEEN 1000 AND 3000;

-- 2) union all: 합집합으로 중복된 데이터도 출력한다 
SELECT ename, sal 
FROM emp 
WHERE job = 'SALESMAN'
UNION all
SELECT ename, SAL 
FROM emp 
WHERE sal BETWEEN 1000 AND 3000;

-- 3) intersect: 교집합으로 두개가 모두 해당되는 데이터만 출력한다
SELECT ename, sal 
FROM emp 
WHERE job = 'SALESMAN'
INTERSECT 
SELECT ename, SAL 
FROM emp 
WHERE sal BETWEEN 1000 AND 3000;

-- 4) minus: 먼저 사용된 sql문 기준으로 뒤의 sql문 결과 제외 후 출력한다
SELECT ename, sal 
FROM emp 
WHERE job = 'SALESMAN'
minus
SELECT ename, SAL 
FROM emp 
WHERE sal BETWEEN 1000 AND 3000;

SELECT ename, SAL 
FROM emp 
WHERE sal BETWEEN 1000 AND 3000
MINUS 
SELECT ename, sal 
FROM emp 
WHERE job = 'SALESMAN';


-- 2. 직책별 최고 급여자의 사원정보

SELECT *
FROM EMP e 
WHERE (sal, job) in (
	SELECT max(sal) msal, job
	FROM emp 
	GROUP BY job
);

CREATE VIEW emp_job_msal 
AS SELECT ename, empno, sal, job 
FROM emp 
WHERE (sal, job) in (
	SELECT max(sal) msal, job
	FROM emp 
	GROUP BY job
);

SELECT * FROM emp_job_msal;


			