
/*
#subquery
1. 개요
하나의 SQL 명령문의 결과를 다른 SQL 명령문에 전달하기 위해 두 개 이상의
SQL 명령문을 하나의 SQL명령문으로 연결하여 처리하는 방법
	* 서브쿼리의 필요성
	예시) 교수 테이블에서 '전은지' 교수와 직급이 동일한 모든 교수의 이름 검색
	
2. 처리방식
	1) 교수 테이블에서 '전은지' 교수의 직급 검색하는 SQL 명령문 실행
	2) 교수 테이블의 직급 컬럼에서 1에서 얻은 결과 값과 동일한 직급을 가진 
		교수를 검색하는 SQL 명령문 실행
	3) 1,2의 결과인 SQL 명령문의 처리과정을 통합하여 하나의 SQL 명령문으로 처리 

3. 실행순서
	1) main query에 최하단에 있는 부분부터 실행해서 
		결과값을 가지고 상위에 있는 query로 전달한다. 
	


*/

-- SMITH와 동일한 부서의 사원정보를 출력하기
SELECT *
FROM EMP  
WHERE deptno = (
	SELECT DEPTNO 
	FROM EMP 
	WHERE ename = 'SMITH');
	

-- 응용1) WARD와 같은 직책에 있는 사원들의 정보를 출력하기
-- 응용2) KING을 관리자로 둔 사원정보를 출력하기 
-- 응용3) JAMES와 같은 입사월에 있는 사원정보 출력하기

SELECT * 
FROM emp 
WHERE job = (
	SELECT JOB
	FROM emp 
	WHERE ename = 'WARD');
	
-- 이게 이해가 잘 안갔음 
SELECT *
FROM emp
WHERE mgr = (
	SELECT empno
	FROM emp
	WHERE ename = 'KING');

SELECT * FROM emp;
SELECT * FROM dept;
	
SELECT *
FROM emp 
WHERE to_char(hiredate, 'MM') = (
	SELECT to_char(hiredate, 'MM')
	FROM emp 
	WHERE ename = 'JAMES');
	

/*
#서브쿼리의 종류
1. 단일행 서버 쿼리
	- 서버쿼리의 결과값이 단일 데이터로 조건에서 사용할 때 활용된다.
	- 비교연산자(=, >, <, >=, <=, !=)등으로 활용할 수 있다
	
2. 다중행 서버 쿼리
	- 서버쿼리의 결과값이 다중으로 조건에서 사용할 때 활용된다	
	- 다중행 비교연산자 : in, any, some, all, exists 등을 활용할 수 있다. 
	
*/

-- 부서번호 10에서 급여가 가장 높은 사람의 정보를 출력하기 
SELECT max(sal)
FROM emp 
WHERE deptno = 10;

SELECT *
FROM EMP 
WHERE sal = (
	SELECT max(sal)
	FROM emp
	WHERE deptno = 10);


-- 부서번호 20에서 평균 급여보다 급여가 높은 사원의 정보 출력하기
SELECT *
FROM emp 
WHERE sal > (
	SELECT avg(sal)
	FROM emp 
	WHERE deptno = 20);
	

SELECT * FROM emp;


-- 응용1) 부서번호 20에서 가장 적은 연봉보다 같거나 적은 사원들을 출력하기
-- 응용2) 2사분기에 입사한 사원들의 평균 급여보다 많은 사원들을 출력하기
-- 응용3) comm이 가장 많은 사원의 정보 출력하기 (6조)

SELECT *
FROM emp 
WHERE sal <= (
	SELECT min(sal) 
	FROM emp 
	WHERE deptno = 20); 
	
SELECT *
FROM emp 
WHERE sal > (
	SELECT avg(sal) 
	FROM emp 
	WHERE TO_char(hiredate, 'Q') = '2');
	
SELECT *
FROM EMP 
WHERE comm = (
	SELECT max(comm)
	FROM emp);

-- ㅇㅏ 안되네
SELECT *
FROM emp 
WHERE max(comm);


-- 다중행 subquery 
-- 연봉이 1000~ 3000 사이의 직책에 해당하는 사원 출력하기
SELECT *
FROM emp 
WHERE job in(
	SELECT DISTINCT job
	FROM emp 
	WHERE sal BETWEEN 1000 AND 3000);


-- 두가지 조건을 합쳐야할때
SELECT *
FROM emp; 

SELECT *
FROM emp 
WHERE (sal, deptno) = (800, 20);


/*

#다중행 서브쿼리
	1) 두개의 column이 다 해당할 때 처리해주는 내용을 확인할 수 있다. 
	2) 사용방법
		select *
		from emp 
		where (sal, deptno) in (subquery);

*/


-- 응용1) 4~6월에 입사한 사원의 직책과 같은 사람들을 출력하기 
-- 응용2) 연봉이 2000~ 3000 사이의 사원정보의 부서번호와 같은 사람들 출력하기 (1조)

SELECT *
FROM emp 
WHERE job IN (
	SELECT job
	FROM EMP e 
	WHERE to_char(hiredate, 'MM') BETWEEN 4 AND 6);

SELECT *
FROM emp 
WHERE deptno in (
	SELECT DISTINCT deptno
	FROM emp 
	WHERE sal BETWEEN 2000 AND 3000);


-- 한개의 컬럼 조건이 아닌 두 개 이상의 컬럼이 다 맞는 경우에 처리하는 subquery
SELECT *
FROM EMP e 
WHERE (sal, deptno) IN (
	SELECT sal, deptno 
	FROM EMP 	
	WHERE sal >= 5000);


-- 부서별로 연봉이 가장 높은 사원 정보를 출력하기
SELECT *
FROM EMP 
WHERE (deptno, sal) IN (
	SELECT deptno, max(sal) 
	FROM emp
	GROUP BY deptno);

-- 위의 그룹이 다중으로 설정되어있기 때문에 원하는 결과를 가져올 수 있다.


-- 응용1) 부서별 최근 입사자의 정보를 부서번호로 정렬하여 출력하기
-- 응용2) 직책별 최저 연봉자의 정보를 연봉으로 정렬하여 출력하기
-- 응용3) 분기별 최고 연봉자의 정보를 분기로 정렬하여 출력하기 (2조)

SELECT * FROM emp;

-- 정렬하는거는 서브쿼리에 붙이는게 아니라 밖에 큰쿼리에 붙여줘야함
SELECT *
FROM emp 
WHERE (deptno, hiredate) IN (
	SELECT deptno, max(hiredate) 
	FROM emp 
	GROUP BY deptno)
ORDER BY deptno;
	
SELECT *
FROM emp 
WHERE (job, sal) IN (
	SELECT job, min(sal) 
	FROM emp 
	GROUP BY JOB)
ORDER BY sal;
	
SELECT to_char(hiredate, 'Q') "분기" , a.*
FROM emp a
WHERE (to_char(hiredate, 'Q'), sal) IN (
	SELECT to_char(hiredate, 'Q'), max(sal)
	FROM emp 
	GROUP BY to_char(hiredate, 'Q'))
ORDER BY 분기;

-- order by 컬럼명을 통해 데이터를 정렬 기준을 설정하여
-- 데이터를 확인할 때 보다 효과적으로 내림차순 오름차순으로 처리결과를 볼 수 있다.
SELECT * FROM emp;



/*
#exists(서버쿼리), not exists(서버쿼리)
1. 서버쿼리에서 검색된 결과가 하나라도 존재하거나 존재하지 않을 때
	메인 쿼리의 조건을 참/거짓 처리해준다.
2. subquery의 데이터의 조회된 결과가 있기만 하면 아무런 연관관계없이 
	main query의 데이터를 수행처리해준다.

*/


-- comm이 null이 아닌 데이터가 존재할 때 조회 처리
SELECT *
FROM emp 
WHERE exists(
	SELECT *
	FROM emp 
	WHERE comm = 2422);

-- comm이 null이 아닌 데이터가 존재하지 않을 때 조회처리
SELECT *
FROM emp 
WHERE NOT exists(
	SELECT *
	FROM emp 
	WHERE comm = 2422);
