
/*
#정리문제
== DB
1. update 기본 형식을 기술하세요.
	update 테이블명
	set 컬럼1 = 변경할 데이터1,
		컬럼2 = 컬럼명 + 추가데이터 (DB에서는 += 불가능)
		컬럼3 = 컬럼명 || '추가문자열데이터',
		컬럼4 = ( subquery ),
		(컬럼명1, 컬럼명2) = (selece 결과1, 결과2) - 단일 row데이터의 경우
	where 조건 = 조건데이터;

2. emp03 테이블에 comm이 0이거나 null인 데이터는 sal의 10%할당하여 수정 처리하세요.

3. subquery를 활용하여, emp03테이블의 사원명이 BLACKE 사람의 입사일을 부서명 30번의 최근 입사일로 
처리를 하세요.


*/

SELECT * FROM emp03;

-- 2. 
UPDATE EMP03 
SET comm = sal*0.1
WHERE comm IS NULL;

UPDATE emp03
SET comm = sal * 0.1
WHERE nvl(comm, 0) = 0;


--3.
UPDATE emp03 
SET hiredate = 
	(SELECT max(hiredate)	
	FROM emp03 
	WHERE deptno = 30)
WHERE ename = 'BLAKE';
			
SELECT * FROM emp;

SELECT max(hiredate)
FROM emp03 
WHERE deptno = 30; 
