/*
#마무리문제
1. job이 'SALESMAN' 인 데이터를 출력하되, 컬럼은 ename, job, sal을 선택하기
2. 부서번호(deptno)가 20이고 sal이 4000미만인 데이터 출력하기
3. 연봉(sal)이 2000에서 3000 사이거나, 직책(job)이 'SALESMAN' 인 사원의 사원번호(empno), 사원명(ename), 직책(job), 연봉(sal)을 출력하기
4. 부서번호가 10이 아닌 경우 처리하기
5. job이 CLERK가 아닌 데이터 출력하기
6. comm이 null이 아닌 데이터를 ename과 sal의 comm의 합산한 급여로 출력하기
*/

-- 확인용
SELECT *
FROM emp;

-- 1. 
SELECT ename, job, sal
FROM emp 
WHERE job = 'SALESMAN';

-- 2.
SELECT *
FROM emp 
WHERE deptno = 20 AND sal < 4000;

--3.  
-- 나오는 결과 없음.. 
-- and나 or이나 같은 연산자임
SELECT empno AS "사원번호(EMPNO)", ename "사원명(ename)", 
		job "직책(JOB)", sal "연봉(SAL)" 
FROM emp 
WHERE sal >= 2000 AND sal <= 3000 AND job = 'SALESMAN';

-- 문제에 연봉이 2000~4000 이거나이므로 or을 사용해야함
-- 헐 이렇게 하니까 데이터가 나옴
SELECT empno AS "사원번호(EMPNO)", ename "사원명(ename)", 
		job "직책(JOB)", sal "연봉(SAL)" 
FROM emp 
WHERE (sal >= 2000 AND sal <= 3000)
or (job = 'SALESMAN');

-- 4.
SELECT *
FROM emp 
WHERE deptno != 10;

-- 5. 
SELECT *
FROM emp 
WHERE job = 'CLERK';

-- 이것도 문제 잘못읽음 clerk가 아닌 데이터 나오게 하는건데;
SELECT *
FROM emp 
WHERE job != 'CLERK';

-- 6.
SELECT ename || '(' || (sal + comm) || ')' AS "합산한 급여"
FROM emp 
WHERE comm IS NOT NULL;

-- 이렇ㄱ ㅔ 나오는걸 원하신거임 ㅎ.. 
SELECT ename, sal, comm, sal+comm "합산"
FROM emp 
WHERE comm IS NOT NULL;


-- #과제 공지사항
-- 과제 진행시 피드백이 필요한 경우 그 사람의 과제제출물로 풀이.. 
-- 명시하면 해주신다고 함, 설명 내용의 자세한 풀이 필요시 명시 

