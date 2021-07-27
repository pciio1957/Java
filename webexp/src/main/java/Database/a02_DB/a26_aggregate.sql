
/*

#집합형 sql 처리
1. 기본형식
	sql1
	집합관련키워드
	sql2;
	1) 두 sql의 결과의 type과 갯수는 컬럼명이 동일하여야 한다. 

2. 종류
	1) union : 합집합 - 두 sql의 결과 공통데이터는 1번만 나와서 
		처리결과를 확인할 수 있다.
	2) union all : 합집합이지만 중복된 데이터를 처리결과로 확인할 수 있다.
	3) intersect : 교집합으로 두 개의 집합의 공통되는 집합을 출력한다.
	4) minus : 먼저 위치한 select문을 기준으로 다른 select문과 공통된 데이터를 제외한 항목만 추출


*/

-- 동일한 결과는 제외하고 나머지 내용 출력
SELECT '홍길동' name, 75 kor FROM dual
union
SELECT '김길동' name, 80 kor FROM dual
union
SELECT '이길동' name, 90 kor FROM dual
union
SELECT '홍길동' name, 75 kor FROM dual;

-- 합집합 결과에 중복데이터도 결과로 출력된다
SELECT '홍길동' name, 75 kor FROM dual
UNION all
SELECT '김길동' name, 80 kor FROM dual
UNION all
SELECT '이길동' name, 90 kor FROM dual
UNION all
SELECT '홍길동' name, 75 kor FROM dual;

-- intersect 이용 실습
SELECT * FROM emp;

-- 연봉이 1000~3000 사이의 사원명, 직책, 부서번호와
-- 연봉이 2000~5000 사이의 사원명, 직책, 부서번호의 교집합을 구하기
-- 결과가 동일할때만 제대로된 결과가 출력됨
SELECT ename, job, deptno, sal 
FROM emp 
WHERE sal BETWEEN 1000 AND 3000
INTERSECT 
SELECT ename, job, deptno, sal 
FROM emp 
WHERE sal BETWEEN 2000 AND 5000;

-- 집합연산의 정렬은 마지막 최종 라인에서 처리한다.
SELECT ename, job, deptno, sal 
FROM emp 
WHERE sal BETWEEN 1000 AND 3000
minus 
SELECT ename, job, deptno, sal 
FROM emp 
WHERE sal BETWEEN 2000 AND 5000;


-- 응용1) 부서번호 10과 부서번호 20인 데이터의 합집합을 구하세요
-- 응용2) 연봉이 0~3000인 사람과 2000~5000인 사함의 중복상관없는 합집합을 구하세요
-- 응용3) 상반기에 입사한 사람과 2/4분기에 입사한 사람의 차집합을 구하세요
-- 응용4) 1980년도에 입사한 사람과 1981년도에 입사한 사람중에 월이 같은 교집합을 구하세요
-- 1번 풀고 보내고 2번 풀고 보내는 식을 5조 제출하기 

SELECT * FROM emp;

SELECT ename, empno, sal
FROM EMP e 
WHERE deptno = 10
minus
SELECT ename, empno, sal
FROM emp 
WHERE deptno = 20;

SELECT *
FROM EMP e  
WHERE sal between 0 AND 3000
UNION ALL 
SELECT *
FROM emp 
WHERE sal BETWEEN 2000 AND 5000;

SELECT ename, empno, sal, hiredate
FROM emp 
WHERE to_char(hiredate, 'Q') BETWEEN 1 AND 6
INTERSECT 
SELECT ename, empno, sal, HIREDATE 
FROM emp 
WHERE to_char(hiredate, 'Q') = 2;

SELECT ename, empno, sal, to_char(hiredate, 'YYYY')
FROM emp 
WHERE to_char(hiredate, 'YYYY') = '1980'
INTERSECT 
SELECT ename, empno, sal, to_char(hiredate, 'YYYY') 
FROM emp 
WHERE to_char(hiredate, 'YYYY') = '1981';

-- 나타내려는 정보가 3개? 더 많기때문에 서브쿼리를 이용함
SELECT *
FROM emp
WHERE to_char(hiredate, 'MM') = (
	SELECT to_char(hiredate, 'YYYY')
	FROM emp 
	WHERE to_char(hiredate, 'YYYY') = '1980'
	INTERSECT 
	SELECT to_char(hiredate, 'YYYY') 
	FROM emp 
	WHERE to_char(hiredate, 'YYYY') = '1981'
);
