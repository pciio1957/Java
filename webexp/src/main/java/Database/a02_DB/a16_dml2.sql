
/*
#데이터 수정
1. update 명령문은 테이블에 저장된 데이터 수정을 위한 조작어이다.
2. 기본형식	
	update 테이블명
	set 컬럼1 = 변경할 데이터, 
		컬럼2 = 변경할 데이터, 
		컬럼3 = 변경할 데이터
	where 조건문
3. 주의사항
	1) where 절을 생략하면 테이블의 모든 행이 수정된다.
	2) 조건문과 변경할 데이터 부분을 subquery를 이용해 처리할 수 있다.

*/

SELECT * FROM emp02;

UPDATE EMP02 	
	SET empno = 5005,
		mgr = 7698,
		sal = 3600,
		comm = 500,
		deptno = 40
	WHERE ename = 'SMITH';
	

-- 응용1) emp02의 comm이 null인 데이터를 모두 1000으로 수정처리하기 
-- 응용2) emp02에서 1/4분기에 입사한 사원정보는 현재날짜로 수정하기 (2조)

UPDATE EMP02 	
	SET comm = 1000
	WHERE comm IS null;
	
UPDATE EMP02  
	SET hiredate = sysdate 
	WHERE to_char(hiredate,'Q') = '1';
	
SELECT * FROM emp02;



/*

# subquery를 통한 수정처리
1. update 명령문에 set부분이나 where 조건절에 subquery를 이용하여 수정처리하는 것을 말한다.
2. 다른 테이블이나 현재 테이블에 정보를 변경할 때 일단 query를 수행한 결과로 해당 데이터를
	수정 처리하는 것을 말한다
3. 변경할 컬럼의 타입과 갯수는 반드시 일치해야한다.
4. 유형
	1) set부분 subquery 활용
		- 한개의 컬럼 : set 컬럼명 = (결과가 1개인 컬럼데이터)
		- 두개의 컬럼 : set (컬렁명1, 컬럼명2) = (결과가 2개인 컬럼데이터)
*/


-- 부서번호가 10인 사원정보의 급여를 부서번호 20인 사원의 최고급여로 변경
SELECT sal
FROM emp03 
WHERE deptno = 10;

SELECT max(sal)
FROM emp03 
WHERE deptno = 20;

UPDATE emp03 
SET sal = (SELECT max(sal)
			FROM emp03 
			WHERE deptno = 20)
WHERE deptno = 10;


-- 응용1) job이 SALESMAN인 평균 급여를 사원번호 7499에 급여로 변경처리 (5조)
UPDATE emp03 
SET sal = (SELECT avg(sal) 
			FROM emp 
			WHERE job = 'SALESMAN') 
WHERE empno = 7499;

SELECT * FROM emp03;


-- 응용2) 1사분기 최고급여를 사원명 ALLEN의 급여로 변경처리 (5, 6조)
-- 왜 안되나했더니 테이블 이름을 안적음 
UPDATE emp03
SET sal = (SELECT max(sal)
			FROM emp 
			WHERE to_char(hiredate, 'Q') = '1')
WHERE ename = 'ALLEN';

-- group by는 그룹으로 묶어줄때 사용/ having은 그룹의 조건 설정 



/*

#데이터 삭제
1. 개요 
	1) delete 명령문은 테이블에 저장된 데이터 삭제를 위한 조작어이다.
	2) where 절을 생략하면 테이블의 모든 행을 삭제한다.
2. 기본 형식
	1) delete from 테이블명 
		from 테이블명
		where 조건명 

*/

CREATE TABLE emp21
AS SELECT * FROM emp;

SELECT * FROM emp21;

-- 실습) 이름이 SMITH인 데이터를 삭제 처리
DELETE FROM emp21  
WHERE ename= 'SMITH';

-- 응용1) job이 SALESMAN인 데이터 삭제 처리하기
delete FROM emp21 
where job = 'SALESMAN';

-- 응용2) sal이 1000~2000사이인 데이터를 삭제처리하기
DELETE FROM emp21
WHERE sal BETWEEN 1000 and 2000;

-- 응용3) 12월에 입사한 사원을 삭제하기 
DELETE FROM EMP21 
WHERE to_char(hiredate, 'MM') = '12';

-- 응용4) 부서별 최고 급여자들을 삭제하기(4조) - 못풀었음
DELETE FROM emp21 
WHERE sal = (
	SELECT max(sal)
	FROM emp21
	GROUP BY deptno
);

-- sal만 조건을 주는게 아니라 deptno도 사용하므로 가져와야함 
DELETE FROM emp21 
WHERE (deptno, sal) in (
	SELECT deptno, max(sal)
	FROM emp21
	GROUP BY deptno
);

